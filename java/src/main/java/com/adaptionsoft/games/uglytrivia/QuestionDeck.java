package com.adaptionsoft.games.uglytrivia;

import java.util.List;

import static java.util.Arrays.asList;

public class QuestionDeck {
    private final Category science;
    private final Category sports;
    private final Category rock;
    private final Category pop;
    private final List<Category> categories;

    public QuestionDeck() {
        pop = new Category("Pop", asList(0, 4, 8));
        science = new Category("Science", asList(1, 5, 9));
        sports = new Category("Sports", asList(2, 6, 10));
        rock = new Category("Rock", asList(3, 7, 11));
        categories = asList(pop, science, sports, rock);
    }

    String currentCategoryForPosition(int position) {
        return categories
                .stream()
                .filter(category -> category.isPlacedOn(position))
                .findFirst()
                .orElseThrow(OutOfTheBoard::new)
                .name();
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
