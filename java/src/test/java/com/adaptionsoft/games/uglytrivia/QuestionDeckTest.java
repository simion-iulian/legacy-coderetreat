package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class QuestionDeckTest {

    @ParameterizedTest
    @CsvSource({"0, Pop", "4, Pop", "8, Pop"})
    void pop_category(int position, String category) {
        String actual = new QuestionDeck().currentCategoryForPosition(position);

        assertThat(actual, is(category));
    }
}