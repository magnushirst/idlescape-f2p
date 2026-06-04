package org.dreambot.controllers;

import org.dreambot.GameStateMock;
import org.dreambot.controllers.bis.BestInSlotController;
import org.dreambot.controllers.bis.BisRequest;
import org.dreambot.controllers.bis.BisResult;
import org.dreambot.controllers.bis.BisStat;
import org.dreambot.controllers.bis.HandMode;
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
        BisResult bisResult =  new BestInSlotController().calculateBestInSlot(request);

        Assertions.assertFalse(bisResult.getBisSlots().isEmpty(), "Expected no items in the result");

    }
}
