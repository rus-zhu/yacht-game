package com.ruszhu.yacht.domain;

import java.util.List;

public class Game {

    private DiceRoll lastRoll = DiceRoll.of(0, 0, 0, 0, 0);

    private final DiceRoller diceRoller;
    private final Scoreboard scoreboard = new Scoreboard();

    public Game() {
        diceRoller = new DiceRoller();
    }

    public Game(DiceRoller diceRoller) {
        this.diceRoller = diceRoller;
    }

    public void rollDice() {
        lastRoll = diceRoller.roll();
    }

    public DiceRoll lastRoll() {
        return lastRoll;
    }

    public int score() {
        return scoreboard.score();
    }

    public void assignRollTo(ScoreCategory scoreCategory) {
        scoreboard.scoreAs(scoreCategory, lastRoll);
    }

    public List<ScoredCategory> scoredCategories() {
        return scoreboard.scoredCategories();
    }
}
