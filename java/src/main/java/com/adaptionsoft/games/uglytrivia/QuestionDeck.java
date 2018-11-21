package com.adaptionsoft.games.uglytrivia;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class QuestionDeck {
    private final List<Category> categories;

    public QuestionDeck(List<Category> categories) {
        this.categories = categories;
    }

    String currentCategoryForPosition(int position) {
        return categoryFor(position).name();
    }

    String askQuestionFor(String categoryName) {
        return categoryFor(categoryName).nextQuestion();
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
