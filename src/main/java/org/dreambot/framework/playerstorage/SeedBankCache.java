package org.dreambot.framework.playerstorage;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.dreambot.api.wrappers.items.Item;
import org.dreambot.framework.config.CachedConfig;

@Getter
@Setter
public class SeedBankCache implements CachedConfig {
    List<Item> items = new ArrayList<>();
    double updatedAt = 0;

    public void setItems(List<Item> items) {
        this.items = items;
        updatedAt = System.currentTimeMillis();
    }

    @Override
    public boolean isPlayerSpecific() {
        return true;
    }
}
