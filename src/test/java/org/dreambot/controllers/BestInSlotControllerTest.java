package org.dreambot.controllers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.dreambot.GameStateMock;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.controllers.bis.BestInSlotController;
import org.dreambot.controllers.bis.BisRequest;
import org.dreambot.controllers.bis.BisResult;
import org.dreambot.controllers.bis.BisStat;
import org.dreambot.controllers.bis.HandMode;
import org.dreambot.gamedata.items.equipment.EquipmentRef;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class BestInSlotControllerTest {
    private static final Path SNAPSHOT_DIR = Path.of("src", "test", "resources", "bisSnapshots");
    private static final Path GENERATED_CSV_DIR = Path.of("target", "test-generated");

    private GameStateMock gameStateMock;

    @BeforeEach
    void setUp() {
        gameStateMock = new GameStateMock();
    }

    @AfterEach
    void tearDown() {
        gameStateMock.close();
    }

    @ParameterizedTest(name = "Test BIS for {0} in One Handed mode")
    @EnumSource(value = BisStat.class)
    void testBisMatchesPreviousSnapshot(BisStat metric) {
        BisRequest request = new BisRequest(metric, HandMode.ONE_HANDED, false);
        BisResult bisResult = new BestInSlotController().calculateBestInSlot(request);
        Assertions.assertFalse(bisResult.getBisBySlot().isEmpty(), "Expected no items in the result");

        assertSnapshotMatches(bisResult, metric);
    }

    private void assertSnapshotMatches(BisResult bisResult, BisStat metric) {
        String actual = exportBisResultToCsv(bisResult);
        writeGeneratedCsv(actual, metric);

        try {
            Path snapshotPath = getSnapshotPath(metric);
            String expected = normalizeCsv(Files.readString(snapshotPath, StandardCharsets.UTF_8));

            Assertions.assertEquals(
                    expected,
                    normalizeCsv(actual),
                    "Generated BIS CSV did not match the stored snapshot: " + snapshotPath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to validate BIS CSV snapshot", e);
        }
    }

    private String exportBisResultToCsv(BisResult bisResult) {
        Map<EquipmentSlot, List<EquipmentRef>> bisBySlot = bisResult.getBisBySlot();
        List<EquipmentSlot> sortedSlots = Arrays.stream(EquipmentSlot.values())
                .sorted(Comparator.comparing(Enum::name))
                .collect(Collectors.toList());

        int maxItems = sortedSlots.stream()
                .map(slot ->
                        bisBySlot.getOrDefault(slot, Collections.emptyList()).size())
                .max(Integer::compareTo)
                .orElse(0);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sortedSlots.size(); i++) {
            if (i > 0) {
                builder.append(',');
            }
            builder.append(sortedSlots.get(i).name().toLowerCase());
        }
        builder.append('\n');

        for (int rank = 0; rank < maxItems; rank++) {
            for (int slotIndex = 0; slotIndex < sortedSlots.size(); slotIndex++) {
                if (slotIndex > 0) {
                    builder.append(',');
                }

                List<EquipmentRef> items = bisBySlot.getOrDefault(sortedSlots.get(slotIndex), Collections.emptyList());
                if (rank < items.size()) {
                    builder.append(items.get(rank).toString().toLowerCase());
                }
            }
            builder.append('\n');
        }

        return builder.toString();
    }

    private void writeGeneratedCsv(String csv, BisStat metric) {
        Path outputPath = GENERATED_CSV_DIR.resolve(metric.name().toLowerCase() + ".csv");
        try {
            try {
                Files.createDirectories(outputPath.getParent());
            } catch (FileAlreadyExistsException ignored) {
                // parent already exists as a file path entry in some environments
            }
            Files.writeString(outputPath, csv, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write generated BIS CSV", e);
        }
    }

    private Path getSnapshotPath(BisStat metric) {
        return SNAPSHOT_DIR.resolve(metric.name().toLowerCase() + ".csv");
    }

    private String normalizeCsv(String value) {
        return value.replace("\r\n", "\n").trim();
    }
}
