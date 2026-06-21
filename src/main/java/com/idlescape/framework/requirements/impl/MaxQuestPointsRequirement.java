package com.idlescape.framework.requirements.impl;

import com.idlescape.framework.requirements.IRequirement;
import java.util.Arrays;
import org.dreambot.api.methods.quest.book.Quest;

public final class MaxQuestPointsRequirement implements IRequirement {
    @Override
    public boolean hasMet() {
        return Arrays.stream(Quest.values())
                .filter(quest -> quest.getType() != Quest.Type.MINIQUEST)
                .allMatch(Quest::isFinished);
    }
}
