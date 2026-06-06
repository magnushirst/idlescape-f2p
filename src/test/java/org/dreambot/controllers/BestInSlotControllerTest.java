package org.dreambot.controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import org.junit.jupiter.api.Test;

public class BestInSlotControllerTest {
    private GameStateMock gameStateMock;

    @BeforeEach
    void setUp() {
        gameStateMock = new GameStateMock();
    }

    @AfterEach
    void tearDown() {
        gameStateMock.close();
    }

    @Test
    void testBestInSlotController() {
        BisRequest request = new BisRequest(BisStat.ATTACK_MAGIC, HandMode.ONE_HANDED, false);
        BisResult bisResult = new BestInSlotController().calculateBestInSlot(request);
        Assertions.assertFalse(bisResult.getBisBySlot().isEmpty(), "Expected no items in the result");

        exportBisResultToCsv(bisResult, "bis_results.csv");
    }

    private void exportBisResultToCsv(BisResult bisResult, String filename) {
        Map<EquipmentSlot, List<EquipmentRef>> bisBySlot = bisResult.getBisBySlot();

        // Get sorted slots to ensure consistent column order
        List<EquipmentSlot> sortedSlots = new ArrayList<>(bisBySlot.keySet());
        sortedSlots.sort((a, b) -> a.name().compareTo(b.name()));

        // Find the maximum number of items in any slot (for row count)
        int maxItems = bisBySlot.values().stream().mapToInt(List::size).max().orElse(0);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Write header row with slot names
            for (int i = 0; i < sortedSlots.size(); i++) {
                if (i > 0) writer.write(",");
                writer.write(sortedSlots.get(i).name().toLowerCase());
            }
            writer.newLine();

            // Write equipment name rows
            for (int rank = 0; rank < maxItems; rank++) {
                for (int slotIndex = 0; slotIndex < sortedSlots.size(); slotIndex++) {
                    if (slotIndex > 0) writer.write(",");

                    EquipmentSlot slot = sortedSlots.get(slotIndex);
                    List<EquipmentRef> items = bisBySlot.get(slot);

                    if (rank < items.size()) {
                        EquipmentRef item = items.get(rank);
                        writer.write(item.toString().toLowerCase());
                    }
                }
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to export BIS results to CSV", e);
        }
    }
}
