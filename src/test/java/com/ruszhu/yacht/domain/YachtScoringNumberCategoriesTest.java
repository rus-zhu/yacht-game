package com.ruszhu.yacht.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class YachtScoringNumberCategoriesTest {
    @Test
    public void rollOf23456ResultsInScoreOfZeroForOnesCategory() throws Exception {
        YachtScorer yachtScorer = new YachtScorer();

        int score = yachtScorer.scoreAsOnes(List.of(2, 3, 4, 5, 6));

        assertThat(score)
                .isZero();
    }

    @Test
    public void rollOf12345ResultsInScoreOf1ForOnesCategory() throws Exception {
        YachtScorer yachtScorer = new YachtScorer();

        int score = yachtScorer.scoreAsOnes(List.of(1, 2, 3, 4, 5));

        assertThat(score)
                .isEqualTo(1);
    }

    @Test
    public void rollOf11111ResultsInScoreOf5ForOnesCategory() throws Exception {
        YachtScorer yachtScorer = new YachtScorer();

        int score = yachtScorer.scoreAsOnes(List.of(1, 1, 1, 1, 1));

        assertThat(score)
                .isEqualTo(5);
    }

    @Test
    public void rollsOf12346ScoresForFivesCategory() throws Exception {
        YachtScorer yachtScorer = new YachtScorer();

        int score = yachtScorer.scoreAsFives(List.of(1, 2, 3, 4, 6));

        assertThat(score)
                .isZero();
    }

    @Test
    public void rollOf13336Scores9ForThreesCategory() throws Exception {
        YachtScorer yachtScorer = new YachtScorer();

        int score = yachtScorer.scoreAsThrees(List.of(1, 3, 3, 3, 6));

        assertThat(score)
                .isEqualTo(9);
    }

    @Test
    public void rollOf12556Scores10ForFivesCategory() throws Exception {
        YachtScorer yachtScorer = new YachtScorer();

        int score = yachtScorer.scoreAsFives(List.of(1, 2, 5, 5, 6));

        assertThat(score)
                .isEqualTo(10);
    }

    @Test
    public void rollOf22345Scores4ForTwosCategory() throws Exception {
        YachtScorer yachtScorer = new YachtScorer();

        int score = yachtScorer.scoreAsTwos(List.of(2, 2, 3, 4, 5));

        assertThat(score)
                .isEqualTo(2 + 2);
    }

    @Test
    public void rollOf66644Scores18ForSixesCategory() throws Exception {
        YachtScorer yachtScorer = new YachtScorer();

        int score = yachtScorer.scoreAsSixes(List.of(6, 6, 6, 4, 4));

        assertThat(score)
                .isEqualTo(6 + 6 + 6);
    }
}
