package org.dreambot.framework.requirements.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.diary.Diary;
import org.dreambot.framework.requirements.IRequirement;
import org.dreambot.gamedata.diary.DiaryDifficulty;

@Getter
@AllArgsConstructor
public final class DiaryCompletedRequirement implements IRequirement {
    private final Diary diary;
    private final DiaryDifficulty difficulty;

    @Override
    public boolean hasMet() {
        return difficulty.isComplete(diary);
    }
}
