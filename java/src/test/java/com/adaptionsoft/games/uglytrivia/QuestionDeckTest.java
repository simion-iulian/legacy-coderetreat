package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.IntStream;

import static java.lang.String.format;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QuestionDeckTest {
    private QuestionDeck game;

    @BeforeEach
    void setUp() {
        List<Category> categories = asList(
                new Category("HipHop", asList(0, 1)),
                new Category("Rocket Science", asList(2, 3)));

        IntStream.range(0, 50).forEach(i ->
                categories.forEach(category -> category.addQuestion(format("%s Question %d", category.name(), i))));

        game = new QuestionDeck(categories);
    }

    @ParameterizedTest
    @CsvSource({
            "0, HipHop", "1, HipHop",
            "2, Rocket Science", "3, Rocket Science"
    })
    void question_for_categories_placed_explicitly(int position, String expectedCategory) {
        String actualCategory = game.currentCategoryForPosition(position);

        assertThat(actualCategory, is(expectedCategory));
    }

    @ParameterizedTest
    @ValueSource(ints = {12, 32832932, Integer.MAX_VALUE, Integer.MIN_VALUE})
    void question_out_of_the_board(int position) {

        assertThrows(OutOfTheBoard.class, () -> game.currentCategoryForPosition(position));
    }

    @ParameterizedTest
    @ValueSource(strings = {"HipHop", "Rocket Science"})
    void ask_question_for_pop_multiple_times(String category) {
        QuestionDeck questionDeck = game;

        IntStream.range(0, 50).forEach(i -> assertThat(questionDeck.askQuestionFor(category), is(category + " Question " + i)));
    }

    @Test
    void ask_question_for_an_unknown_category() {
        QuestionDeck questionDeck = game;

        assertThrows(NoSuchCategory.class, () -> questionDeck.askQuestionFor("::unknown-category::"));
    }

    @Test
    void asking_more_questions_then_available() {
        QuestionDeck questionDeck = game;

        IntStream.range(0, 50).forEach(i -> questionDeck.askQuestionFor("HipHop"));

        assertThrows(NoRemainingQuestion.class, () -> questionDeck.askQuestionFor("HipHop"));
    }

}