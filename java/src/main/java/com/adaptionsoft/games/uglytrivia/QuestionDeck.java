package com.adaptionsoft.games.uglytrivia;

public class QuestionDeck {
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

    void askQuestionFor(String category, Game game) {
        if (category == "Pop")
            System.out.println(game.popQuestions.removeFirst());
        if (category == "Science")
            System.out.println(game.scienceQuestions.removeFirst());
        if (category == "Sports")
            System.out.println(game.sportsQuestions.removeFirst());
        if (category == "Rock")
            System.out.println(game.rockQuestions.removeFirst());
    }
}
