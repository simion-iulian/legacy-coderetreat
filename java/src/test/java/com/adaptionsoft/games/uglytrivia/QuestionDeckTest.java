package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class QuestionDeckTest {

    @Test
    void pop_category() {
        String actual = new QuestionDeck().currentCategoryForPosition(0);

        assertThat(actual, is("Pop"));
    }
}