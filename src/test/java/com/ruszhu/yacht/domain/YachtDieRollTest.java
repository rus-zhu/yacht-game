package com.ruszhu.yacht.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class YachtDieRollTest {

    @Test
    public void rollFiveDiceResultIsIn12345() throws Exception {
        // Given
        Yacht yacht = new Yacht(new DieRoller() {
            private int die = 0;
            @Override
            public int roll() {
                return ++die;
            }
        });

        // When
        String result = yacht.rollDice();

        // Then
        assertThat(result)
                .isEqualTo("12345");
    }

    @Test
    public void rollDiceResultsInFiveDice() throws Exception {
        // Given
        Yacht yacht = new Yacht(new RandomDieRoller());

        String result = yacht.rollDice();

        assertThat(result)
                .hasSize(5);

    }

}
