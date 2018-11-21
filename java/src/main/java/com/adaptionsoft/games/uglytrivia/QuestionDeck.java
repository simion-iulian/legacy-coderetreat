package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class QuestionDeck {
    LinkedList<String> popQuestions = new LinkedList();
    List<Integer> popPlaces = asList(0, 4, 8);

    LinkedList<String> scienceQuestions = new LinkedList();
    LinkedList<String> sportsQuestions = new LinkedList();
    LinkedList<String> rockQuestions = new LinkedList();

    String currentCategoryForPosition(int position) {
        if (popPlaces.contains(position)) return "Pop";
        if (position == 1) return "Science";
        if (position == 5) return "Science";
        if (position == 9) return "Science";
        if (position == 2) return "Sports";
        if (position == 6) return "Sports";
        if (position == 10) return "Sports";
        return "Rock";
    }

    String askQuestionFor(String category) {
        String question = "";
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

    public String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    public void fillQuestion() {
        for (int i = 0; i < 50; i++) {
            this.popQuestions.addLast("Pop Question " + i);
            this.scienceQuestions.addLast(("Science Question " + i));
            this.sportsQuestions.addLast(("Sports Question " + i));
            this.rockQuestions.addLast(createRockQuestion(i));
        }
    }
}
