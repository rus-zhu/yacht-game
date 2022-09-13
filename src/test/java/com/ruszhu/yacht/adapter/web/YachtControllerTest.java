package com.ruszhu.yacht.adapter.web;

import com.ruszhu.yacht.StubDiceRoller;
import com.ruszhu.yacht.domain.Game;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;

public class YachtControllerTest {

    @Test
    public void rollingDiceReturnsRollInResultsPage() throws Exception {
        Game game = new Game(StubDiceRoller.createDiceRollerFor(3, 1, 4, 1, 5));
        YachtController yachtController = new YachtController(game);

        yachtController.rollDice();
        Model model = new ConcurrentModel();
        yachtController.rollResult(model);

        assertThat(model.getAttribute("roll"))
                .isEqualTo("3 1 4 1 5");

        assertThat(model.containsAttribute("score"))
                .isTrue();
    }

}