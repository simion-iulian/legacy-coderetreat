package com.adaptionsoft.games.uglytrivia;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

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
}
