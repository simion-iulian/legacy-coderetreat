package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;

public class Game {
    ArrayList players = new ArrayList();
    int[] places = new int[6];
    int[] purses  = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;
    private final QuestionDeck questionDeck;
    private PenaltyBox penaltyBox;

    public Game(QuestionDeck aQuestionDeck){
        questionDeck = aQuestionDeck;
        penaltyBox = new PenaltyBox();
    }

    public boolean isPlayable() {
		return (howManyPlayers() >= 2);
	}

	public boolean add(String playerName) {
	    players.add(playerName);
	    places[howManyPlayers()] = 0;
	    purses[howManyPlayers()] = 0;

	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + players.size());
		return true;
	}
	
	public int howManyPlayers() {
		return players.size();
	}

	public void roll(int roll) {
		System.out.println(players.get(currentPlayer) + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (inPenaltyBox[currentPlayer]) {
		    penaltyBox.containsPlayer(currentPlayer);

            final boolean oddNumberedRoll = (roll % 2 != 0);
            isGettingOutOfPenaltyBox = oddNumberedRoll;

		    printPlayerPenaltyBoxStatus();

		    if (isGettingOutOfPenaltyBox) {
                movePlayersPlace(roll);

                printPlayerLocation();
                printCurrentCategory();
                askQuestion();
			}
			
		} else {

            movePlayersPlace(roll);

            printPlayerLocation();
            printCurrentCategory();
            askQuestion();
		}
		
	}

    private void printCurrentCategory() {
        System.out.println("The category is " + currentCategory());
    }

    private void printPlayerPenaltyBoxStatus() {
        final String penaltyBoxStatus = isGettingOutOfPenaltyBox ? "" : "not ";
        System.out.println(players.get(currentPlayer) + " is "
            + penaltyBoxStatus + "getting out of the penalty box");
    }

    private void printPlayerLocation() {
        System.out.println(players.get(currentPlayer)
            + "'s new location is "
            + places[currentPlayer]);
    }

    private void movePlayersPlace(int roll) {
        places[currentPlayer] = places[currentPlayer] + roll;
        if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;
    }

    private void askQuestion() {
        System.out.println(questionDeck.askQuestionFor(currentCategory()));
    }


    private String currentCategory() {
        return questionDeck.currentCategoryForPosition(places[currentPlayer]);
    }

    public boolean wasCorrectlyAnswered() {
		if (inPenaltyBox[currentPlayer]){
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				purses[currentPlayer]++;
				System.out.println(players.get(currentPlayer) 
						+ " now has "
						+ purses[currentPlayer]
						+ " Gold Coins.");
				
				boolean winner = didPlayerWin();
                currentPlayer++;
                if (currentPlayer == players.size()) currentPlayer = 0;


				return winner;
			} else {
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;
				return true;
			}
			
			
			
		} else {
		
			System.out.println("Answer was corrent!!!!");
			purses[currentPlayer]++;
			System.out.println(players.get(currentPlayer) 
					+ " now has "
					+ purses[currentPlayer]
					+ " Gold Coins.");
			
			boolean winner = didPlayerWin();
			currentPlayer++;
			if (currentPlayer == players.size()) currentPlayer = 0;
			
			return winner;
		}
	}
	
	public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(players.get(currentPlayer)+ " was sent to the penalty box");
		inPenaltyBox[currentPlayer] = true;
		penaltyBox.putPlayer(currentPlayer);
		
		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;
		return true;
	}


	private boolean didPlayerWin() {
		return !(purses[currentPlayer] == 6);
	}
}
