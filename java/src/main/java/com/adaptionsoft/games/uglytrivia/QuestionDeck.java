package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class QuestionDeck {
    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

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
            System.out.println(this.popQuestions.removeFirst());
        if (category == "Science")
            System.out.println(this.scienceQuestions.removeFirst());
        if (category == "Sports")
            System.out.println(this.sportsQuestions.removeFirst());
        if (category == "Rock")
            System.out.println(this.rockQuestions.removeFirst());
    }

    public String createRockQuestion(int index){
		return "Rock Question " + index;
	}

    public void fillQuestion(Game game) {
        for (int i = 0; i < 50; i++) {
			this.popQuestions.addLast("Pop Question " + i);
			this.scienceQuestions.addLast(("Science Question " + i));
			this.sportsQuestions.addLast(("Sports Question " + i));
			this.rockQuestions.addLast(createRockQuestion(i));
    	}
    }
}
