package com.idlescape.framework.playerstorage;

import com.idlescape.framework.config.CachedConfig;
import com.idlescape.framework.log.StyledLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.Getter;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.wrappers.items.Item;

@Getter
public class BankCache implements CachedConfig {
    private static final StyledLogger LOGGER = new StyledLogger(BankCache.class);
    private List<BankItemSnapshot> items = new ArrayList<>();
    private long updatedAt = 0L;
    private static boolean hasWarnedCache = false;

    @Override
    public boolean isPlayerSpecific() {
        return true;
    }

    @Override
    public String getConfigFileName() {
        return "bank-cache";
    }

    @Override
    public void onSave() {
        if (Bank.isCached()) {
            List<Item> liveCache = Bank.getBankHistoryCache();
            if (!liveCache.isEmpty()) {
                this.setItems(new ArrayList<>(liveCache));
                LOGGER.log("Saved live bank cache: " + liveCache.size() + " items");
            } else {
                LOGGER.warn(
                        "Live bank cache unavailable or empty during save. Keeping persisted bank cache unchanged.");
            }
        } else {
            LOGGER.warn("Bank.isCached() was false during save. Keeping persisted bank cache unchanged.");
        }
    }

    public void setItems(List<Item> items) {
        if (items == null || items.isEmpty()) {
            LOGGER.warn("Attempted to persist empty bank cache; ignoring.");
            return;
        }
        List<Item> safeCopy = new ArrayList<>(items);

        this.items = safeCopy.stream()
                .filter(Objects::nonNull)
                .map(BankItemSnapshot::fromItem)
                .collect(Collectors.toCollection(ArrayList::new));

        this.updatedAt = System.currentTimeMillis();
    }

    public static void warnBankNotCached() {
        if (!hasWarnedCache) {
            LOGGER.warn("No live or persisted bank cache is available.");
            hasWarnedCache = true;
        }
    }

    public List<Item> toItems() {
        if (items == null || items.isEmpty()) {
            return Collections.emptyList();
        }

        return items.stream()
                .filter(Objects::nonNull)
                .map(snapshot -> new Item(snapshot.getId(), snapshot.getAmount(), snapshot.getSlot()))
                .collect(Collectors.toList());
    }
}
