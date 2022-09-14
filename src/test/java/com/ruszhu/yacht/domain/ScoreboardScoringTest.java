package com.ruszhu.yacht.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreboardScoringTest {

    @Test
    public void givenLastRollOf_11234_ScoreAsOnesCategoryResultsInScoreOf2() throws Exception {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.scoreAs(ScoreCategory.ONES, DiceRoll.of(1, 1, 2, 3, 4));

        assertThat(scoreboard.score())
                .isEqualTo(1 + 1);
    }

    @Test
    public void givenLastRollOf_44455_ScoresAsFullHouseResultsInScoreOf22() throws Exception {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.scoreAs(ScoreCategory.FULLHOUSE, DiceRoll.of(4, 4, 4, 5, 5));

        assertThat(scoreboard.score())
                .isEqualTo(4 + 4 + 4 + 5 + 5);
    }

    @Test
    public void givenLastRollOf_65456_ScoreAsSixesResultsInScoreOf12() throws Exception {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.scoreAs(ScoreCategory.SIXES, DiceRoll.of(6, 5, 4, 5, 6));

        assertThat(scoreboard.score())
                .isEqualTo(6 + 6);
    }

    @Test
    public void twoRollsAssignedToDifferentCategoriesResultsInSumOfBothScores() throws Exception {
        DiceRoll fullHouseRoll = DiceRoll.of(1, 1, 1, 2, 2);
        DiceRoll sixesRoll = DiceRoll.of(6, 5, 1, 5, 6);

        Scoreboard scoreboard = new Scoreboard();

        scoreboard.scoreAs(ScoreCategory.FULLHOUSE, fullHouseRoll);
        scoreboard.scoreAs(ScoreCategory.SIXES, sixesRoll);

        assertThat(scoreboard.score())
                .isEqualTo((1 + 1 + 1 + 2 + 2) + (6 + 6));
    }

}
