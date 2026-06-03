package org.dreambot.framework.requirements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.BooleanSupplier;
import lombok.NoArgsConstructor;
import org.dreambot.api.methods.diary.Diary;
import org.dreambot.api.methods.music.Song;
import org.dreambot.api.methods.quest.book.Quest;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.gamedata.diary.DiaryDifficulty;
import org.dreambot.gamedata.items.GenericItemRef;

@NoArgsConstructor
public final class RequirementBuilder {
    private enum Operator {
        AND,
        OR
    }

    private IRequirement current;
    private Operator nextOperator = Operator.AND;
    private boolean negateNext;
    private final List<IRequirement> requirements = new ArrayList<>();

    public RequirementBuilder require(IRequirement requirement) {
        IRequirement next = Objects.requireNonNull(requirement);
        if (negateNext) {
            next = next.not();
            negateNext = false;
        }

        requirements.add(next);

        if (current == null) {
            current = next;
        } else if (nextOperator == Operator.AND) {
            current = current.and(next);
        } else {
            current = current.or(next);
        }

        nextOperator = Operator.AND;
        return this;
    }

    public RequirementBuilder require(BooleanSupplier supplier) {
        return require(Requirements.from(supplier));
    }

    public RequirementBuilder and() {
        nextOperator = Operator.AND;
        return this;
    }

    public RequirementBuilder or() {
        nextOperator = Operator.OR;
        return this;
    }

    public RequirementBuilder not() {
        negateNext = !negateNext;
        return this;
    }

    public RequirementBuilder finished(Quest... quests) {
        return require(Requirements.questFinished(quests));
    }

    public RequirementBuilder started(Quest... quests) {
        return require(Requirements.questStarted(quests));
    }

    public RequirementBuilder varbitEquals(int varbitId, int value) {
        return require(Requirements.varBitEquals(varbitId, value));
    }

    public RequirementBuilder songUnlocked(Song song) {
        return require(Requirements.songUnlocked(song));
    }

    public RequirementBuilder ownsItem(GenericItemRef genericItemRef) {
        return require(Requirements.ownsItem(genericItemRef));
    }

    public RequirementBuilder hasLevel(Skill skill, int minLevel) {
        return require(Requirements.hasLevel(skill, minLevel));
    }

    public static RequirementBuilder withLevel(Skill skill, int minLevel) {
        return new RequirementBuilder().hasLevel(skill, minLevel);
    }

    public RequirementBuilder completed(Diary diary, DiaryDifficulty diaryDifficulty) {
        return require(Requirements.completed(diary, diaryDifficulty));
    }

    public RequirementBuilder completedAll(DiaryDifficulty diaryDifficulty) {
        return require(Requirements.completedAll(diaryDifficulty));
    }

    public RequirementBuilder maxQuestPoints() {
        return require(Requirements.maxQuestPoints());
    }

    public RequirementBuilder questPoints(int minQuestPoints) {
        return require(Requirements.questPoints(minQuestPoints));
    }

    public RequirementBuilder maxLevel() {
        return require(Requirements.maxLevel());
    }

    public RequirementBuilder combatLevel(int minCombatLevel) {
        return require(Requirements.combatLevel(minCombatLevel));
    }

    public RequirementBuilder totalLevel(int minTotalLevel) {
        return require(Requirements.totalLevel(minTotalLevel));
    }

    private IRequirement create() {
        if (current == null) {
            return Requirements.alwaysTrue();
        }
        return current;
    }

    public List<IRequirement> getRequirements() {
        return Collections.unmodifiableList(requirements);
    }

    public Requirement build() {
        IRequirement composite = create();
        return new Requirement(composite, getRequirements());
    }
}
