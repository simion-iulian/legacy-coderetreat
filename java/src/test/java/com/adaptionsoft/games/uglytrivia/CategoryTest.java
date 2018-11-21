package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CategoryTest {

    @Test
    void is_placed() {
        Category category = new Category("not-needed", asList(1, 2));

        assertTrue(category.isPlacedOn(1));
        assertTrue(category.isPlacedOn(2));
    }

    @Test
    void ask_for_a_single_question() {
        Category category = new Category("banana", emptyList());

        String question = "Isn't this a great question?";
        category.addQuestion(question);

        assertThat(category.nextQuestion(),is(question));
    }

    @Test
    void ask_for_a_multiple_question() {
        Category category = new Category("banana", emptyList());

        String question1 = "Isn't this a great question?";
        String question2 = "Isn't this another great question?";

        category.addQuestion(question1);
        category.addQuestion(question2);

        assertThat(category.nextQuestion(), is(question1));
        assertThat(category.nextQuestion(), is(question2));
    }

    @Test
    void no_more_questions_available() {
        Category category = new Category("not-needed", emptyList());

        category.addQuestion("a question");
        category.nextQuestion();

        assertThrows(NoRemainingQuestion.class, category::nextQuestion);
    }

    @Test
    void can_be_named() {
        Category pop = new Category("banana", emptyList());

        assertTrue(pop.isNamed("banana"));
        assertThat(pop.name(), is("banana"));
    }
}