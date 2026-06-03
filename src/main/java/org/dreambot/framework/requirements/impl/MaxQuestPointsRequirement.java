package org.dreambot.framework.requirements.impl;

import java.util.Arrays;
import org.dreambot.api.methods.quest.book.Quest;
import org.dreambot.framework.requirements.IRequirement;

public final class MaxQuestPointsRequirement implements IRequirement {
    @Override
    public boolean hasMet() {
        return Arrays.stream(Quest.values())
                .filter(quest -> quest.getType() != Quest.Type.MINIQUEST)
                .allMatch(Quest::isFinished);
    }
}
