package com.idlescape.framework.requirements.impl;

import com.idlescape.framework.requirements.IRequirement;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.quest.Quests;
import org.dreambot.api.methods.quest.book.Quest;

@Getter
@AllArgsConstructor
public final class QuestStartedRequirement implements IRequirement {
    private final Quest[] quests;

    @Override
    public boolean hasMet() {
        return Arrays.stream(quests).allMatch(Quests::isStarted);
    }
}
