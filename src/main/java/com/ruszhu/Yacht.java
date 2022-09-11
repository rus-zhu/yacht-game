package com.ruszhu;

import java.util.List;

public class Yacht {

    private final DieRoller dieRoller;

    public Yacht(DieRoller dieRoller) {
        this.dieRoller = dieRoller;
    }

    public Yacht() {
        this.dieRoller = new RandomDieRoller();
    }

    public String rollDice() {
        String result = "";
        for (int i = 0; i < 5; i++) {
            result += String.valueOf(dieRoller.roll());
        }
        return result;
    }

    public int scoreAsOnes(String roll) {
        return calculateScore(roll, '1', 1);
    }

    public int scoreAsThrees(String roll) {
        return calculateScore(roll, '3', 3);
    }

    public int scoreAsFives(String roll) {
        return calculateScore(roll, '5', 5);
    }

    private static int calculateScore(String roll, char dieSide, int scoreForDie) {
        int count = (int) (roll.chars()
                .filter(c -> c == dieSide)
                .count());
        return count * scoreForDie;
    }

    public int scoreAsFullHouse(String roll) {
        return 0;
    }

    public int scoreAsTwos(List<Integer> dice) {
        int count = (int) dice.stream()
                .filter(die -> die == 2)
                .count();
        return count * 2;
    }
}
