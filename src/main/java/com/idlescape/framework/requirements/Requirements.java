package com.idlescape.framework.requirements;

import com.idlescape.framework.requirements.impl.AllOfRequirement;
import com.idlescape.framework.requirements.impl.AlwaysFalseRequirement;
import com.idlescape.framework.requirements.impl.AlwaysTrueRequirement;
import com.idlescape.framework.requirements.impl.AnyOfRequirement;
import com.idlescape.framework.requirements.impl.CombatLevelRequirement;
import com.idlescape.framework.requirements.impl.CompletedAllDiariesRequirement;
import com.idlescape.framework.requirements.impl.DiaryCompletedRequirement;
import com.idlescape.framework.requirements.impl.HasLevelRequirement;
import com.idlescape.framework.requirements.impl.MaxLevelRequirement;
import com.idlescape.framework.requirements.impl.MaxQuestPointsRequirement;
import com.idlescape.framework.requirements.impl.OwnsItemRequirement;
import com.idlescape.framework.requirements.impl.QuestFinishedRequirement;
import com.idlescape.framework.requirements.impl.QuestPointsRequirement;
import com.idlescape.framework.requirements.impl.QuestStartedRequirement;
import com.idlescape.framework.requirements.impl.SongUnlockedRequirement;
import com.idlescape.framework.requirements.impl.SupplierRequirement;
import com.idlescape.framework.requirements.impl.TotalLevelRequirement;
import com.idlescape.framework.requirements.impl.VarBitEqualsRequirement;
import com.idlescape.framework.requirements.impl.VarPlayerEqualsRequirement;
import com.idlescape.gamedata.diary.DiaryDifficulty;
import com.idlescape.gamedata.items.GenericItemRef;
import java.util.function.BooleanSupplier;
import org.dreambot.api.methods.diary.Diary;
import org.dreambot.api.methods.music.Song;
import org.dreambot.api.methods.quest.book.Quest;
import org.dreambot.api.methods.skills.Skill;

final class Requirements {
    private Requirements() {}

    public static IRequirement alwaysTrue() {
        return new AlwaysTrueRequirement();
    }

    public static IRequirement alwaysFalse() {
        return new AlwaysFalseRequirement();
    }

    public static IRequirement from(BooleanSupplier supplier) {
        return new SupplierRequirement(supplier);
    }

    public static IRequirement questFinished(Quest... quests) {
        return new QuestFinishedRequirement(quests);
    }

    public static IRequirement questStarted(Quest... quests) {
        return new QuestStartedRequirement(quests);
    }

    public static IRequirement varBitEquals(int varbitId, int value) {
        return new VarBitEqualsRequirement(varbitId, value);
    }

    public static IRequirement varPlayerEquals(int varPlayer, int value) {
        return new VarPlayerEqualsRequirement(varPlayer, value);
    }

    public static IRequirement songUnlocked(Song song) {
        return new SongUnlockedRequirement(song);
    }

    public static IRequirement ownsItem(GenericItemRef genericItemRef) {
        return new OwnsItemRequirement(genericItemRef);
    }

    public static IRequirement hasLevel(Skill skill, int minLevel) {
        return new HasLevelRequirement(skill, minLevel);
    }

    public static IRequirement combatLevel(int minLevel) {
        return new CombatLevelRequirement(minLevel);
    }

    public static IRequirement totalLevel(int minTotalLevel) {
        return new TotalLevelRequirement(minTotalLevel);
    }

    public static IRequirement completed(Diary diary, DiaryDifficulty diaryDifficulty) {
        return new DiaryCompletedRequirement(diary, diaryDifficulty);
    }

    public static IRequirement completedAll(DiaryDifficulty diaryDifficulty) {
        return new CompletedAllDiariesRequirement(diaryDifficulty);
    }

    public static IRequirement maxLevel() {
        return new MaxLevelRequirement();
    }

    public static IRequirement maxQuestPoints() {
        return new MaxQuestPointsRequirement();
    }

    public static IRequirement questPoints(int minQuestPoints) {
        return new QuestPointsRequirement(minQuestPoints);
    }

    public static IRequirement allOf(IRequirement... requirements) {
        return new AllOfRequirement(requirements);
    }

    public static IRequirement anyOf(IRequirement... requirements) {
        return new AnyOfRequirement(requirements);
    }

    public static RequirementBuilder builder() {
        return new RequirementBuilder();
    }
}
