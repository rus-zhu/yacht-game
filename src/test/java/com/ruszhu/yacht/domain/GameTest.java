package com.ruszhu.yacht.domain;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    public void rollDiceThenQueryLastRollReturnsLastRoll() throws Exception {
        Game game = new Game();

        game.rollDice();

        assertThat(game.lastRoll())
                .isNotNull();
    }

    @Test
    public void newGameResultsInScoreOfZero() throws Exception {
        Game game = new Game();

        assertThat(game.score())
                .isZero();
    }

    @Test
    public void givenLastRollOf_11234_ScoreAsOnesCategoryResultsInScoreOf2() throws Exception {
        Game game = new Game();

        game.rollDice();
        game.assignRollToNumberOnesCategory();

        assertThat(game.score())
                .isEqualTo(1 + 1);
    }

    @Disabled
    public void givenLastRollOf_44455_ScoresAsFullHouseResultsInScoreOf22() throws Exception {
        Game game = new Game();

        game.rollDice();
        game.assignRollToFullHouseCategory();

        assertThat(game.score())
                .isEqualTo(4 + 4 + 4 + 5 + 5);
    }
}
