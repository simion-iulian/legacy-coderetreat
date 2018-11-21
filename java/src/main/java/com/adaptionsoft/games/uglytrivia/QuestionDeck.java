package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class QuestionDeck {
    LinkedList<String> popQuestions = new LinkedList();
    LinkedList<String> scienceQuestions = new LinkedList();
    LinkedList<String> sportsQuestions = new LinkedList();
    LinkedList<String> rockQuestions = new LinkedList();

    String currentCategoryForPosition(int position) {
        if (position == 0) return "Pop";
        if (position == 4) return "Pop";
        if (position == 8) return "Pop";
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
        if (category == "Pop") {
            question = this.popQuestions.removeFirst();
        }
        if (category == "Science") {
            question = this.scienceQuestions.removeFirst();
        }
        if (category == "Sports") {
            question = this.sportsQuestions.removeFirst();
        }
        if (category == "Rock") {
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
