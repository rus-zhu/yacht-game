package com.ruszhu.yacht.adapter.web;

import com.ruszhu.yacht.domain.DiceRoll;

import java.util.stream.Collectors;

public class RollView {
    public static String from(DiceRoll diceRoll) {
        return diceRoll
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
