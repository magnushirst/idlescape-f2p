package org.dreambot.framework.requirements.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.quest.Quests;
import org.dreambot.framework.requirements.IRequirement;

@Getter
@AllArgsConstructor
public final class QuestPointsRequirement implements IRequirement {
    private final int minQuestPoints;


    @Override
    public boolean hasMet() {
        return Quests.getQuestPoints() >= minQuestPoints;
    }
}

