package ru.geekbrains.lesson1;

abstract class Fruit {

    private final float weight;

    public Fruit(final float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }
}
