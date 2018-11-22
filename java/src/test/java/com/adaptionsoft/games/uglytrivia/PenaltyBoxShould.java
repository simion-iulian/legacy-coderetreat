package com.adaptionsoft.games.uglytrivia;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PenaltyBoxShould {

    @Test
    void contain_a_player_that_was_put() {
        PenaltyBox penaltyBox = new PenaltyBox();

        penaltyBox.putPlayer(1);

        assertThat(penaltyBox.containsPlayer(1), is(true));
    }
}
