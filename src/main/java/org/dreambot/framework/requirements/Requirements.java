package org.dreambot.framework.requirements;

import java.util.function.BooleanSupplier;
import org.dreambot.api.methods.diary.Diary;
import org.dreambot.api.methods.music.Song;
import org.dreambot.api.methods.quest.book.Quest;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.framework.requirements.impl.AllOfRequirement;
import org.dreambot.framework.requirements.impl.AlwaysFalseRequirement;
import org.dreambot.framework.requirements.impl.AlwaysTrueRequirement;
import org.dreambot.framework.requirements.impl.AnyOfRequirement;
import org.dreambot.framework.requirements.impl.CombatLevelRequirement;
import org.dreambot.framework.requirements.impl.CompletedAllDiariesRequirement;
import org.dreambot.framework.requirements.impl.DiaryCompletedRequirement;
import org.dreambot.framework.requirements.impl.HasLevelRequirement;
import org.dreambot.framework.requirements.impl.MaxLevelRequirement;
import org.dreambot.framework.requirements.impl.MaxQuestPointsRequirement;
import org.dreambot.framework.requirements.impl.OwnsItemRequirement;
import org.dreambot.framework.requirements.impl.QuestFinishedRequirement;
import org.dreambot.framework.requirements.impl.QuestPointsRequirement;
import org.dreambot.framework.requirements.impl.QuestStartedRequirement;
import org.dreambot.framework.requirements.impl.SongUnlockedRequirement;
import org.dreambot.framework.requirements.impl.SupplierRequirement;
import org.dreambot.framework.requirements.impl.TotalLevelRequirement;
import org.dreambot.framework.requirements.impl.VarBitEqualsRequirement;
import org.dreambot.framework.requirements.impl.VarPlayerEqualsRequirement;
import org.dreambot.gamedata.diary.DiaryDifficulty;
import org.dreambot.gamedata.items.GenericItemRef;

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
