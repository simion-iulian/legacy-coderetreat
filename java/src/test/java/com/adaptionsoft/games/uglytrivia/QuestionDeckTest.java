package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QuestionDeckTest {

    @ParameterizedTest
    @CsvSource({
            "0, Pop", "4, Pop", "8, Pop",
            "1, Science", "5, Science", "9, Science",
            "2, Sports", "6, Sports", "10, Sports",
            "3, Rock", "7, Rock", "11, Rock",
    })
    void question_for_categories_placed_explicitly(int position, String expectedCategory) {
        String actualCategory = new QuestionDeck().currentCategoryForPosition(position);

        assertThat(actualCategory, is(expectedCategory));
    }

    @ParameterizedTest
    @ValueSource(ints = {12, 32832932, Integer.MAX_VALUE, Integer.MIN_VALUE})
    void question_out_of_the_board(int position) {
        String actualCategory = new QuestionDeck().currentCategoryForPosition(position);

        assertThat(actualCategory, is("Rock"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Pop", "Science", "Sports", "Rock"})
    void ask_question_for_pop_multiple_times(String category) {
        QuestionDeck questionDeck = new QuestionDeck();

        questionDeck.fillQuestion();

        IntStream.range(0, 50).forEach(i -> assertThat(questionDeck.askQuestionFor(category), is(category + " Question " + i)));
    }

    @Test
    void ask_question_for_an_unknown_category() {
        QuestionDeck questionDeck = new QuestionDeck();

        questionDeck.fillQuestion();
        String category = questionDeck.askQuestionFor("::unknown-category::");

        assertThat(category, isEmptyString());
    }

    @Test
    void asking_more_questions_then_available() {
        QuestionDeck questionDeck = new QuestionDeck();

        questionDeck.fillQuestion();
        IntStream.range(0, 50).forEach(i -> questionDeck.askQuestionFor("Pop"));

        assertThrows(NoSuchElementException.class, () -> questionDeck.askQuestionFor("Pop"));
    }
}