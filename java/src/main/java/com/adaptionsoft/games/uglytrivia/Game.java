package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
	private final String ANSWER_WAS_CORRECT = "Answer was correct!!!!";
	private final String ANSWER_WAS_CORRENT = "Answer was corrent!!!!";

	ArrayList players = new ArrayList();
    int[] places = new int[6];
    int[] purses  = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];
    
    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();
    
    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

	public  Game(){
    	for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));
			rockQuestions.addLast(createRockQuestion(i));
    	}
    }

	public String createRockQuestion(int index){
		return "Rock Question " + index;
	}
	
	public boolean isPlayable() {
		return (howManyPlayers() >= 2);
	}

	public boolean add(String playerName) {
		
		
	    players.add(playerName);
	    places[howManyPlayers()] = 0;
	    purses[howManyPlayers()] = 0;
	    inPenaltyBox[howManyPlayers()] = false;
	    
	    printMessage(playerName + " was added");
	    printMessage("They are player number " + players.size());
		return true;
	}
	
	public int howManyPlayers() {
		return players.size();
	}

	public void roll(int roll) {
		printMessage(players.get(currentPlayer) + " is the current player");
		printMessage("They have rolled a " + roll);
		
		if (inPenaltyBox[currentPlayer]) {
			if (isOdd(roll)) {
				isGettingOutOfPenaltyBox = true;
				
				printMessage(players.get(currentPlayer) + " is getting out of the penalty box");
				places[currentPlayer] = places[currentPlayer] + roll;
				if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;
				
				System.out.println(players.get(currentPlayer)
						+ "'s new location is " 
						+ places[currentPlayer]);
				printMessage("The category is " + currentCategory());
				askQuestion();
			} else {
				printMessage(players.get(currentPlayer) + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}
			
		} else {
		
			places[currentPlayer] = places[currentPlayer] + roll;
			if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;
			
			System.out.println(players.get(currentPlayer) 
					+ "'s new location is " 
					+ places[currentPlayer]);
			printMessage("The category is " + currentCategory());
			askQuestion();
		}
	}

	private boolean isOdd(int roll) {
		return roll % 2 != 0;
	}

	private void askQuestion() {
		if (currentCategory() == "Pop")
			System.out.println(popQuestions.removeFirst());
		if (currentCategory() == "Science")
			System.out.println(scienceQuestions.removeFirst());
		if (currentCategory() == "Sports")
			System.out.println(sportsQuestions.removeFirst());
		if (currentCategory() == "Rock")
			System.out.println(rockQuestions.removeFirst());		
	}
	
	
	private String currentCategory() {
		if (places[currentPlayer] == 0) return "Pop";
		if (places[currentPlayer] == 4) return "Pop";
		if (places[currentPlayer] == 8) return "Pop";
		if (places[currentPlayer] == 1) return "Science";
		if (places[currentPlayer] == 5) return "Science";
		if (places[currentPlayer] == 9) return "Science";
		if (places[currentPlayer] == 2) return "Sports";
		if (places[currentPlayer] == 6) return "Sports";
		if (places[currentPlayer] == 10) return "Sports";
		return "Rock";
	}

	public boolean wasCorrectlyAnswered() {
		if (inPenaltyBox[currentPlayer]){
			if (isGettingOutOfPenaltyBox) {
				return nextTurnWhenAnswerIsCorrect(ANSWER_WAS_CORRECT);
			} else {
				advancePlayer();
				return true;
			}
		} else {
			return nextTurnWhenAnswerIsCorrect(ANSWER_WAS_CORRENT);
		}
	}

	private boolean nextTurnWhenAnswerIsCorrect(String answer_was_correct) {
		printMessage(answer_was_correct);

		addToCurrentPlayerPurse();
		printCurrentPlayerPurse();

		boolean winner = didPlayerWin();
		advancePlayer();

		return winner;
	}

	private void printMessage(String s) {
		System.out.println(s);
	}

	private void addToCurrentPlayerPurse() {
		purses[currentPlayer]++;
	}

	private void printCurrentPlayerPurse() {
		printMessage(players.get(currentPlayer)
			+ " now has "
			+ purses[currentPlayer]
			+ " Gold Coins.");
	}

	private void advancePlayer() {
		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;
	}

	public boolean wrongAnswer(){
		printMessage("Question was incorrectly answered");
		printMessage(players.get(currentPlayer)+ " was sent to the penalty box");

		putCurrentPlayerInPenaltyBox();

		advancePlayer();
		return true;
	}

	private void putCurrentPlayerInPenaltyBox() {
		inPenaltyBox[currentPlayer] = true;
	}


	private boolean didPlayerWin() {
		return !(purses[currentPlayer] == 6);
	}
}
