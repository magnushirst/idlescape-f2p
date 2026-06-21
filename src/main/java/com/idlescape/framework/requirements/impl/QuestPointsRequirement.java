package com.idlescape.framework.requirements.impl;

import com.idlescape.framework.requirements.IRequirement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.quest.Quests;

@Getter
@AllArgsConstructor
public final class QuestPointsRequirement implements IRequirement {
    private final int minQuestPoints;

    @Override
    public boolean hasMet() {
        return Quests.getQuestPoints() >= minQuestPoints;
    }
}
