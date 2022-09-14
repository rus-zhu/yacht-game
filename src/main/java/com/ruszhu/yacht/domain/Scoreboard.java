package com.ruszhu.yacht.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;

public class Scoreboard {
    private int score = 0;
    private final YachtScorer yachtScorer = new YachtScorer();
    private final Map<ScoreCategory, Consumer<DiceRoll>> categoryHandlerMap = new EnumMap<>(ScoreCategory.class);

    public Scoreboard() {
        categoryHandlerMap.put(ScoreCategory.ONES, this::scoreAsOnes);
        categoryHandlerMap.put(ScoreCategory.THREES, this::scoreAsThrees);
        categoryHandlerMap.put(ScoreCategory.SIXES, this::scoreAsSixes);
        categoryHandlerMap.put(ScoreCategory.FULLHOUSE, this::scoreAsFullHouse);
    }

    public int score() {
        return score;
    }

    public void scoreAsOnes(DiceRoll lastRoll) {
        score += yachtScorer.scoreAsOnes(lastRoll);
    }

    public void scoreAsThrees(DiceRoll lastRoll) {
        score += yachtScorer.scoreAsThrees(lastRoll);
    }

    public void scoreAsSixes(DiceRoll lastRoll) {
        score += yachtScorer.scoreAsSixes(lastRoll);
    }

    public void scoreAsFullHouse(DiceRoll lastRoll) {
        score += yachtScorer.scoreAsFullHouse(lastRoll);
    }

    public void scoreAs(ScoreCategory scoreCategory, DiceRoll lastRoll) {
        categoryHandlerMap.get(scoreCategory).accept(lastRoll);
    }
}
