package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.Test;

import static java.util.Collections.emptyList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CategoryTest {

    @Test
    void name_of_the_category() {
        Category pop = new Category("banana", emptyList());

        assertTrue(pop.isNamed("banana"));
        assertThat(pop.name(), is("banana"));
    }
}