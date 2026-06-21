package com.idlescape;

import lombok.Getter;
import lombok.Setter;
import org.dreambot.api.methods.Calculations;

@Setter
@Getter
public class BotConfig {
    String currentLeaf;
    String currentBranch;

    public int getLoopDelay() {
        return (int) Calculations.nextGaussianRandom(300, 100);
    }
}
