package com.adaptionsoft.games.uglytrivia;

import java.util.List;
import java.util.stream.IntStream;

import static java.lang.String.*;
import static java.util.Arrays.asList;

public class QuestionDeck {
    private final Category science;
    private final Category sports;
    private final Category rock;
    private final Category pop;
    private final List<Category> categories;

    public QuestionDeck() {
        pop = new Category("Pop", asList(0, 4, 8));
        science = new Category("Science", asList(1, 5, 9));
        sports = new Category("Sports", asList(2, 6, 10));
        rock = new Category("Rock", asList(3, 7, 11));
        categories = asList(pop, science, sports, rock);
    }

    String currentCategoryForPosition(int position) {
        return categories
                .stream()
                .filter(category -> category.isPlacedOn(position))
                .findFirst()
                .orElseThrow(OutOfTheBoard::new)
                .name();
    }

    String askQuestionFor(String categoryName) {
        return categories
                .stream()
                .filter(category -> category.isNamed(categoryName))
                .findFirst()
                .orElseThrow(NoSuchCategory::new)
                .nextQuestion();
    }

    public void fillQuestion() {
        IntStream.range(0, 50).forEach(i ->
                categories.forEach(category -> category.addQuestion(format("%s Question %d", category.name(), i))));
    }
}
