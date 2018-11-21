package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class QuestionDeck {
    LinkedList<String> popQuestions = new LinkedList();
    List<Integer> popPlaces = asList(0, 4, 8);

    LinkedList<String> scienceQuestions = new LinkedList();
    List<Integer> sciencePlaces = asList(1, 5, 9);

    LinkedList<String> sportsQuestions = new LinkedList();
    List<Integer> sportsPlaces = asList(2, 6, 10);

    LinkedList<String> rockQuestions = new LinkedList();
    List<Integer> rockPlaces = asList(3, 7, 11);
    final Category popCategory;

    public QuestionDeck() {
        popCategory = new Category("Pop", asList(0, 4, 8));
    }

    String currentCategoryForPosition(int position) {
        if (popCategory.isPlacedOn(position)) return popCategory.name();
        if (popPlaces.contains(position)) return "Pop";
        if (sciencePlaces.contains(position)) return "Science";
        if (sportsPlaces.contains(position)) return "Sports";
        if (rockPlaces.contains(position)) return "Rock";
        return "Rock";
    }

    String askQuestionFor(String category) {
        String question = "";

        if(popCategory.isNamed(category)){
           question = popCategory.nextQuestion();
        }
        if (category.equals("Pop")) {
            question = this.popQuestions.removeFirst();
        }
        if (category.equals("Science")) {
            question = this.scienceQuestions.removeFirst();
        }
        if (category.equals("Sports")) {
            question = this.sportsQuestions.removeFirst();
        }
        if (category.equals("Rock")) {
            question = this.rockQuestions.removeFirst();
        }
        return question;
    }

    public String createQuestion(final String category, int index) {
        return category + " Question " + index;
    }

    public void fillQuestion() {
        for (int i = 0; i < 50; i++) {
            this.popQuestions.addLast(createQuestion("Pop", i));
            this.scienceQuestions.addLast(createQuestion("Science", i));
            this.sportsQuestions.addLast(createQuestion("Sports", i));
            this.rockQuestions.addLast(createQuestion("Rock", i));
        }
    }
}
