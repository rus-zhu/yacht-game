package com.ruszhu.yacht.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class DiceRoll {
    private final List<Integer> dice;

    private DiceRoll(int die1, int die2, int die3, int die4, int die5) {
        dice = List.of(die1, die2, die3, die4, die5);
    }

    private DiceRoll(List<Integer> dieRolls) {
        dice = Collections.unmodifiableList(dieRolls);
    }

    public static DiceRoll of(int die1, int die2, int die3, int die4, int die5) {
        return new DiceRoll(die1, die2, die3, die4, die5);
    }

    public static DiceRoll from(List<Integer> dieRolls) {
        return new DiceRoll(dieRolls);
    }

    public int countFour(int dieValue) {
        return (int) dice.stream()
                .filter(die -> die == dieValue)
                .count();
    }

    public Stream<Integer> stream() {
        return dice.stream();
    }

    @Override
    public String toString() {
        return "DiceRoll: " + dice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiceRoll diceRoll = (DiceRoll) o;

        return dice.equals(diceRoll.dice);
    }

    @Override
    public int hashCode() {
        return dice.hashCode();
    }
}
