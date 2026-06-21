package com.idlescape.framework.tree;

import static com.idlescape.framework.log.StyledLogger.getShortClassName;
import static org.dreambot.api.utilities.Logger.LogType.INFO;

import com.idlescape.controllers.LoggerController;
import java.util.function.Supplier;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.script.frameworks.treebranch.Branch;
import org.dreambot.api.script.frameworks.treebranch.Leaf;

@AllArgsConstructor
@NoArgsConstructor
public abstract class SmartBranch extends Branch {
    @Setter
    private Supplier<Integer> inactiveSleep = () -> (int) Calculations.nextGaussianRandom(350.0F, 250.0F);

    @Override
    public int onLoop() {
        for (Leaf leaf : this.getChildren()) {
            if (leaf != null && leaf.isValid() && this.getTree() != null) {
                LoggerController.getInstance()
                        .logOnChange(
                                INFO, "Executing branch", "Executing branch: " + getShortClassName(this.getClass(), 1));
                return leaf.onLoop();
            }
        }

        return inactiveSleep.get();
    }
}
