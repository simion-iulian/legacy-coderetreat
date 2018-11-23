package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PenaltyBoxShould {

    @Test
    void contain_a_player_that_was_put() {
        PenaltyBox penaltyBox = new PenaltyBox();

        penaltyBox.putPlayer(1);

        assertThat(penaltyBox.containsPlayer(1), is(true));
    }

    @Test
    void contains_all_players_that_were_put() {
        PenaltyBox penaltyBox = new PenaltyBox();

        penaltyBox.putPlayer(2);

        assertFalse(penaltyBox.containsPlayer(1));
    }

    @ParameterizedTest
    @CsvSource({
            "1, false",
            "2, true",
            "3, false",
            "4, true",
            "5, false",
            "6, true",
    })
    void player_can_answer_question(int roll, boolean expectedAnswer){
        PenaltyBox penaltyBox = new PenaltyBox();

        boolean actualAnswer = penaltyBox.playerCanAnswerQuestion(roll);

        assertThat(actualAnswer, is(expectedAnswer));
    }
}
