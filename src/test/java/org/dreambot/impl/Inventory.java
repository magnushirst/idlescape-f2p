package org.dreambot.impl;

import org.dreambot.api.methods.filter.Filter;
import org.dreambot.api.wrappers.items.Item;

import java.util.Collections;
import java.util.List;

public class Inventory {
    public static boolean contains(int item) {
        return false;
    }

    public static boolean isFull() {
        return true;
    }

    public static int count(int item) {
        return 0;
    }

    public static List<Item> all() {
        return Collections.emptyList();
    }

    public static Item get(int id) {
        return null;
    }

    public static Item get(Filter<Item> filter) {
        return null;
    }
}
