package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;
import java.util.List;

public class Category {
    private final String name;
    private List<Integer> places;
    private LinkedList<String> questions;

    public Category(String name, List<Integer> places) {
        this.name = name;
        this.places = places;
        this.questions = new LinkedList<>();
    }

    public boolean isPlacedOn(int position) {
        return places.contains(position);
    }

    public String name() {
        return name;
    }

    public boolean isNamed(String category) {
        return category.equals(name);
    }

    public String nextQuestion() {
        return questions.removeFirst();
    }

    public void addQuestion(String question) {
        questions.add(question);
    }
}
