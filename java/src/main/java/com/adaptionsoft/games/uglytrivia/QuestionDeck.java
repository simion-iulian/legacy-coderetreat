package com.adaptionsoft.games.uglytrivia;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.lang.String.*;
import static java.util.Arrays.asList;

public class QuestionDeck {
    private final List<Category> categories;

    public QuestionDeck() {
        categories = asList(
                new Category("Pop", asList(0, 4, 8)),
                new Category("Science", asList(1, 5, 9)),
                new Category("Sports", asList(2, 6, 10)),
                new Category("Rock", asList(3, 7, 11)));
    }

    String currentCategoryForPosition(int position) {
        return categoryFor(position).name();
    }

    String askQuestionFor(String categoryName) {
        return categoryFor(categoryName).nextQuestion();
    }

    public void fillQuestion() {
        IntStream.range(0, 50).forEach(i ->
                categories.forEach(category -> category.addQuestion(format("%s Question %d", category.name(), i))));
    }

    private Optional<Category> findFirst(Predicate<Category> predicate) {
        return categories
                .stream()
                .filter(predicate)
                .findFirst();
    }

    private Category categoryFor(String categoryName) {
        return findFirst(category -> category.isNamed(categoryName))
                .orElseThrow(NoSuchCategory::new);
    }

    private Category categoryFor(int position) {
        return findFirst(category -> category.isPlacedOn(position))
                .orElseThrow(OutOfTheBoard::new);
    }
}
