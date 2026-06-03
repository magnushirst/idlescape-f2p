package org.dreambot.framework.requirements.impl;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.diary.Diaries;
import org.dreambot.framework.requirements.IRequirement;
import org.dreambot.gamedata.diary.DiaryDifficulty;

@Getter
@AllArgsConstructor
public final class CompletedAllDiariesRequirement implements IRequirement {
    private final DiaryDifficulty difficulty;

    @Override
    public boolean hasMet() {
        return Diaries.getDiaryNames().stream().map(Diaries::getDiary).allMatch(difficulty::isComplete);
    }
}

