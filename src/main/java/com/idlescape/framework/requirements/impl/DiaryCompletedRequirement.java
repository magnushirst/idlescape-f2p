package com.idlescape.framework.requirements.impl;

import com.idlescape.framework.requirements.IRequirement;
import com.idlescape.gamedata.diary.DiaryDifficulty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.diary.Diary;

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
