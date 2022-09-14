package com.ruszhu.yacht.domain;

public class Game {

    private DiceRoll lastRoll = DiceRoll.of(0, 0, 0, 0, 0);

    private final DiceRoller diceRoller;
    private Scoreboard scoreboard = new Scoreboard();

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

    public void assignRollToNumberOnesCategory() {
        scoreboard.scoreAsOnes(lastRoll);
    }

    public void assignRollToNumberThreesCategory() {
        scoreboard.scoreAsThrees(lastRoll);
    }

    public void assignRollToNumberSixesCategory() {
        scoreboard.scoreAsSixes(lastRoll);
    }

    public void assignRollToFullHouseCategory() {
        scoreboard.scoreAsFullHouse(lastRoll);
    }

    public void assignRollTo(ScoreCategory scoreCategory) {
        scoreboard.scoreAs(scoreCategory, lastRoll);
    }
}
