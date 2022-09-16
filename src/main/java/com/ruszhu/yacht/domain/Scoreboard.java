package com.ruszhu.yacht.domain;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Scoreboard {
    private int score = 0;
    private final YachtScorer yachtScorer = new YachtScorer();
    private final Map<ScoreCategory, Consumer<DiceRoll>> categoryHandlerMap = new EnumMap<>(ScoreCategory.class);

    private final Map<ScoreCategory, DiceRoll> scoredCategories = new HashMap<>();

    public Scoreboard() {
        categoryHandlerMap.put(ScoreCategory.ONES, this::scoreAsOnes);
        categoryHandlerMap.put(ScoreCategory.TWOS, this::scoreAsTwos);
        categoryHandlerMap.put(ScoreCategory.THREES, this::scoreAsThrees);
        categoryHandlerMap.put(ScoreCategory.FOURS, this::scoreAsFours);
        categoryHandlerMap.put(ScoreCategory.FIVES, this::scoreAsFives);
        categoryHandlerMap.put(ScoreCategory.SIXES, this::scoreAsSixes);
        categoryHandlerMap.put(ScoreCategory.FULLHOUSE, this::scoreAsFullHouse);
    }

    public int score() {
        return score;
    }

    private void scoreAsOnes(DiceRoll lastRoll) {
        score += yachtScorer.scoreAsOnes(lastRoll);
    }

    private void scoreAsTwos(DiceRoll lastRoll) {
        score += yachtScorer.scoreAsTwos(lastRoll);
    }

    private void scoreAsThrees(DiceRoll lastRoll) {
        score += yachtScorer.scoreAsThrees(lastRoll);
    }

    private void scoreAsFours(DiceRoll lastRoll) {
        score += yachtScorer.scoreAsFours(lastRoll);
    }

    private void scoreAsFives(DiceRoll lastRoll) {
        score += yachtScorer.scoreAsFives(lastRoll);
    }

    private void scoreAsSixes(DiceRoll lastRoll) {
        score += yachtScorer.scoreAsSixes(lastRoll);
    }

    private void scoreAsFullHouse(DiceRoll lastRoll) {
        score += yachtScorer.scoreAsFullHouse(lastRoll);
    }

    public void scoreAs(ScoreCategory scoreCategory, DiceRoll diceRoll) {
        scoredCategories.put(scoreCategory, diceRoll);
        categoryHandlerMap.get(scoreCategory).accept(diceRoll);
    }

    public List<ScoredCategory> scoredCategories() {
        return scoredCategories.entrySet()
                .stream()
                .map(entity -> new ScoredCategory(
                        entity.getKey(),
                        entity.getValue(),
                        12))
                .collect(Collectors.toList());
    }
}
