package com.adaptionsoft.games.uglytrivia;

import static java.util.Arrays.asList;

public class QuestionDeck {
    private final Category science;
    private final Category sports;
    private final Category rock;
    private final Category pop;

    public QuestionDeck() {
        pop = new Category("Pop", asList(0, 4, 8));
        science = new Category("Science", asList(1, 5, 9));
        sports = new Category("Sports", asList(2, 6, 10));
        rock = new Category("Rock", asList(3, 7, 11));
    }

    String currentCategoryForPosition(int position) {
        if (pop.isPlacedOn(position)) return pop.name();
        if (science.isPlacedOn(position)) return science.name();
        if (sports.isPlacedOn(position)) return sports.name();
        if (rock.isPlacedOn(position)) return rock.name();
        return "Rock";
    }

    String askQuestionFor(String category) {
        if(pop.isNamed(category)){
           return pop.nextQuestion();
        }
        if(science.isNamed(category)){
           return science.nextQuestion();
        }
        if(sports.isNamed(category)){
           return sports.nextQuestion();
        }
        if(rock.isNamed(category)){
            return rock.nextQuestion();
        }
        throw new NoSuchCategory();
    }

    public String createQuestion(final String category, int index) {
        return category + " Question " + index;
    }

    public void fillQuestion() {
        for (int i = 0; i < 50; i++) {
            pop.addQuestion(createQuestion("Pop", i));
            science.addQuestion(createQuestion("Science", i));
            sports.addQuestion(createQuestion("Sports", i));
            rock.addQuestion(createQuestion("Rock", i));
        }
    }
}
