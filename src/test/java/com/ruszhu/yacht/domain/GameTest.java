package com.ruszhu.yacht.domain;

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
    public void assign11234RollToOnesScoringCategoryResultsInScoreOf2() throws Exception {
        Game game = new Game();

        game.rollDice();
        game.assignRollToNumberOnesCategory();

        assertThat(game.score())
                .isEqualTo(2);
    }
}
