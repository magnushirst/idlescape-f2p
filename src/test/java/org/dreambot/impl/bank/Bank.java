package org.dreambot.impl.bank;

import org.dreambot.api.wrappers.items.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bank {
    public static boolean deposit(int id) {
        return false;
    }

    public static boolean deposit(int id, int amount) {
        return false;
    }

    public static boolean depositAll(int id) {
        return false;
    }

    public static boolean depositAllItems() {
        return false;
    }

    public static List<Item> getBankHistoryCache() {
        return Collections.emptyList();
    }

    public static boolean isCached() {
        return false;
    }

    public static boolean isOpen() {
        return false;
    }

    public static List<Item> all() {
        return new ArrayList<>();
    }
}
