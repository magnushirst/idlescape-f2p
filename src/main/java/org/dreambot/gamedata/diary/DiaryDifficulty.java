package org.dreambot.gamedata.diary;

import org.dreambot.api.methods.diary.Diary;

public enum DiaryDifficulty {
    EASY,
    MEDIUM,
    HARD,
    ELITE;

    public boolean isComplete(Diary diary) {
        switch (this) {
            case EASY:
                return diary.easyFinished();
            case MEDIUM:
                return diary.mediumFinished();
            case HARD:
                return diary.hardFinished();
            case ELITE:
                return diary.eliteFinished();
            default:
                return false;
        }
    }
}
