package com.ruszhu;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class YachtScoringFullHouseTest {
    @Test
    public void nonFullHouseRollScoresZero() throws Exception {
        Yacht yacht = new Yacht();

        int score = yacht.scoreAsFullHouse(List.of(1, 2, 3, 4, 5));

        assertThat(score)
                .isZero();
    }

    @Disabled
    public void rollOf33355ScoresAs19() throws Exception {
        Yacht yacht = new Yacht();

        int score = yacht.scoreAsFullHouse(List.of(3, 3, 3, 5, 5));

        assertThat(score)
                .isEqualTo(3 + 3 + 3 + 5 + 5);
    }

    @Disabled
    public void rollOf22666ScoresAs22() throws Exception {
        Yacht yacht = new Yacht();

        int score = yacht.scoreAsFullHouse(List.of(2, 2, 6, 6, 6));

        assertThat(score)
                .as("Should be scored as 2 + 2 + 6 + 6 + 6")
                .isEqualTo(2 + 2 + 6 + 6 + 6);
    }

    @Disabled("Not Yet!")
    public void rollOf11111ScoresAs0() throws Exception {

    }
}
