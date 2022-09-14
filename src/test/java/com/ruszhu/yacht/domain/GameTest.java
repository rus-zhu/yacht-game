package com.ruszhu.yacht.domain;

import com.ruszhu.yacht.StubDiceRoller;
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
    public void lastRollReturnsValueOfMostRecentRollDice() throws Exception {
        DiceRoll diceRoll = DiceRoll.of(6, 5, 4, 3, 2);
        Game game = new Game(new StubDiceRoller(diceRoll));

        game.rollDice();

        assertThat(game.lastRoll())
                .isEqualTo(diceRoll);
    }
}
