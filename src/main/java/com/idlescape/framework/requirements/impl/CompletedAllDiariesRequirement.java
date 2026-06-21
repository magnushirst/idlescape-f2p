package com.idlescape.framework.requirements.impl;

import com.idlescape.framework.requirements.IRequirement;
import com.idlescape.gamedata.diary.DiaryDifficulty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.diary.Diaries;

@Getter
@AllArgsConstructor
public final class CompletedAllDiariesRequirement implements IRequirement {
    private final DiaryDifficulty difficulty;

    @Override
    public boolean hasMet() {
        return Diaries.getDiaryNames().stream().map(Diaries::getDiary).allMatch(difficulty::isComplete);
    }
}
