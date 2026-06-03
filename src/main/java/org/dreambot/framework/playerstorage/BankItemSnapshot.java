package org.dreambot.framework.playerstorage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.dreambot.api.wrappers.items.Item;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankItemSnapshot {
    private int id;
    private int amount;
    private int slot;
    private String name;

    public BankItemSnapshot(int id, int amount, String name) {
        this.id = id;
        this.amount = amount;
        this.name = name;
    }

    public static BankItemSnapshot fromItem(Item item) {
        return new BankItemSnapshot(item.getId(), item.getAmount(), item.getSlot(), item.getName());
    }
}
