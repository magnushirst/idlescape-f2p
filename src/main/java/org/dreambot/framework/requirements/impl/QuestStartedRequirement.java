package org.dreambot.framework.requirements.impl;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.quest.book.Quest;
import org.dreambot.framework.requirements.IRequirement;

@Getter
@AllArgsConstructor
public final class QuestStartedRequirement implements IRequirement {
    private final Quest[] quests;

  @Override
    public boolean hasMet() {
        return Arrays.stream(quests).allMatch(Quest::isStarted);
    }
}

