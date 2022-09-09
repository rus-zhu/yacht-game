package com.ruszhu;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class DieTest {

    @RepeatedTest(100)
    public void rollResultsInBetween1and6() throws Exception {
        DieRoller dieRoller = new RandomDieRoller();

        int roll = dieRoller.roll();

        assertThat(roll)
                .isBetween(1, 6);
    }

}
