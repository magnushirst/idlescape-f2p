package com.idlescape;

import com.idlescape.api.methods.interactive.Players;
import com.idlescape.gamedata.song.Songs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.container.impl.equipment.Equipment;
import org.dreambot.api.methods.music.Song;
import org.dreambot.api.methods.quest.Quests;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.methods.worldhopper.WorldHopper;
import org.dreambot.api.utilities.Logger;
import org.dreambot.api.wrappers.interactive.Player;
import org.dreambot.api.wrappers.items.Item;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class GameStateMock {
    public MockedStatic<Inventory> inventoryMock;
    public MockedStatic<Equipment> equipmentMock;
    public MockedStatic<Bank> bankMock;
    public MockedStatic<Logger> loggerMock;
    public MockedStatic<Quests> questsMock;
    public MockedStatic<Skills> skillsMock;
    public MockedStatic<Songs> songsMock;
    public MockedStatic<Players> playersMock;
    public MockedStatic<WorldHopper> worldHopperMock;

    List<Item> equipment = new ArrayList<>();
    List<Item> inventory = new ArrayList<>();

    public GameStateMock() {
        playersMock = Mockito.mockStatic(Players.class, Mockito.RETURNS_MOCKS);
        questsMock = Mockito.mockStatic(Quests.class, Mockito.RETURNS_MOCKS);
        skillsMock = Mockito.mockStatic(Skills.class, Mockito.RETURNS_MOCKS);
        songsMock = Mockito.mockStatic(Songs.class, Mockito.RETURNS_MOCKS);
        inventoryMock =
                Mockito.mockStatic(Inventory.class, Mockito.withSettings().stubOnly());
        equipmentMock =
                Mockito.mockStatic(Equipment.class, Mockito.withSettings().stubOnly());
        bankMock = Mockito.mockStatic(Bank.class, Mockito.withSettings().stubOnly());
        worldHopperMock = Mockito.mockStatic(WorldHopper.class, Mockito.RETURNS_MOCKS);
        loggerMock = Mockito.mockStatic(Logger.class, Mockito.RETURNS_MOCKS);

        Player playerMock = Mockito.mock(Player.class);
        Mockito.when(playerMock.getName()).thenReturn("Player 1");
        playersMock.when(Players::getLocal).thenReturn(playerMock);
        setBankCacheToContain();
        bankMock.when(Bank::isCached).thenReturn(true);
        skillsMock.when(() -> Skills.getRealLevel(Mockito.any(Skill.class))).thenReturn(1);
        songsMock.when(() -> Songs.isUnlocked(Mockito.any(Song.class))).thenReturn(false);
    }

    public void close() {
        inventoryMock.close();
        equipmentMock.close();
        bankMock.close();
        loggerMock.close();
        questsMock.close();
        skillsMock.close();
        playersMock.close();
        worldHopperMock.close();
        songsMock.close();
    }

    public void setEquipmentToContain(Item... items) {
        equipment.addAll(Arrays.asList(items));
        equipmentMock.when(Equipment::all).thenReturn(equipment);
        for (Item item : items) {
            equipmentMock.when(() -> Equipment.contains(item.getId())).thenReturn(true);
            equipmentMock.when(() -> Equipment.count(item.getId())).thenReturn(item.getAmount());
            equipmentMock.when(() -> Equipment.get(item.getId())).thenReturn(item);
        }
    }

    public void setInventoryToContain(Item... items) {
        inventory.addAll(Arrays.asList(items));
        inventoryMock.when(Inventory::all).thenReturn(inventory);
        for (Item item : items) {
            inventoryMock.when(() -> Inventory.contains(item.getId())).thenReturn(true);
            inventoryMock.when(() -> Inventory.count(item.getId())).thenReturn(item.getAmount());
            inventoryMock.when(() -> Inventory.get(item.getId())).thenReturn(item);
        }
    }

    public void setBankCacheToContain(Item... items) {
        bankMock.when(Bank::getBankHistoryCache).thenReturn(Arrays.stream(items).collect(Collectors.toList()));
        bankMock.when(Bank::all).thenReturn(Arrays.stream(items).collect(Collectors.toList()));
    }

    public static Player getPlayer(String name) {
        Player playerMock = Mockito.mock(Player.class);
        Mockito.when(playerMock.getName()).thenReturn(name);
        return playerMock;
    }
}
