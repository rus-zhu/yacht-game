package com.ruszhu.yacht.domain;

import com.ruszhu.yacht.StubDiceRoller;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreboardCategoryTest {

    @Test
    public void assignRollToFoursCategoryReturnsScoreInfoForThatCategory() throws Exception {
        DiceRoll diceRoll = DiceRoll.of(6, 4, 4, 3, 4);
        Game game = new Game(new StubDiceRoller(diceRoll));

        game.assignRollTo(ScoreCategory.FOURS);

        assertThat(game.scoredCategories())
                .containsOnlyOnce(new ScoredCategory(ScoreCategory.FOURS, DiceRoll.of(6, 4, 4, 3, 4), 12));
    }


}