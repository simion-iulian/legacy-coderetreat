package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CategoryTest {

    @Test
    void is_placed() {
        Category category = new Category("not-needed", asList(1, 2));

        assertTrue(category.isPlacedOn(1));
        assertTrue(category.isPlacedOn(2));
    }

    @Test
    void can_be_named() {
        Category pop = new Category("banana", emptyList());

        assertTrue(pop.isNamed("banana"));
        assertThat(pop.name(), is("banana"));
    }
}