package com.ruszhu;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class YachtScoringTest {
    @Test
    public void rollOf23456ResultsInScoreOfZeroForOnesCategory() throws Exception {
        Yacht yacht = new Yacht();

        String roll = yacht.rollDice();

        int score = yacht.scoreAsOnes("23456");

        assertThat(score)
                .isZero();
    }

    @Test
    public void rollOf12345ResultsInScoreOf1ForOnesCategory() throws Exception {
        Yacht yacht = new Yacht();

        int score = yacht.scoreAsOnes("12345");

        assertThat(score)
                .isEqualTo(1);
    }

    @Test
    public void rollOf11111ResultsInScoreOf5ForOnesCategory() throws Exception {
        Yacht yacht = new Yacht();

        int score = yacht.scoreAsOnes("11111");

        assertThat(score)
                .isEqualTo(5);
    }

    @Test
    public void rollsOf12346ScoresForFivesCategory() throws Exception {
        Yacht yacht = new Yacht();

        int score = yacht.scoreAsFives("12346");

        assertThat(score)
                .isZero();
    }

    @Test
    public void rollOf13336Scores9ForThreesCategory() throws Exception {
        Yacht yacht = new Yacht();

        int score = yacht.scoreAsThrees("13336");

        assertThat(score)
                .isEqualTo(9);
    }

    @Test
    public void rollOf12556Scores10ForFivesCategory() throws Exception {
        Yacht yacht = new Yacht();

        int score = yacht.scoreAsFives("12556");

        assertThat(score)
                .isEqualTo(10);
    }
}
