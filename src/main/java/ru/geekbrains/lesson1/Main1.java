package ru.geekbrains.lesson1;

import java.util.ArrayList;

public class Main1 {
    public static void main(String[] args) {

        /* 3. Задача:
         Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
         Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
        поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
         Для хранения фруктов внутри коробки можно использовать ArrayList;
         Сделать метод getWeight(),
        который высчитывает вес коробки.
        Зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
         Внутри класса Box сделать метод compare(),
        который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра.
        True – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
         Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
        Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
        Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
         Не забываем про метод добавления фрукта в коробку.
        */

        final Box<Fruit> fruitBox = new Box<>();
        fruitBox.addFruit(new Orange(2));
        fruitBox.addFruit(new Orange(4));

        final Box<Fruit> fruitBox1 = new Box<>();
        fruitBox1.addFruit(new Apple(2));
        fruitBox1.addFruit(new Apple(3));
        fruitBox1.addFruit(new Apple(4));

        fruitBox.getWeight();
        fruitBox1.getWeight();

        fruitBox.compare(fruitBox1);

        fruitBox.layOut(new Orange(2));
        fruitBox1.layOut(new Apple(2));

        final Box<Orange> orangeBox = new Box<>();
        orangeBox.pourOver(fruitBox);
    }
}

class Box<T extends Fruit> {

    private final ArrayList<T> fruits;

    protected Box() {
        this.fruits = new ArrayList<>();
    }

    public void addFruit(final T fruit) {
        fruits.add(fruit);
    }

    @SuppressWarnings("UnusedReturnValue")
    public float getWeight() {
        if (fruits.size() == 0) {
            return 0;
        }
        float weight = 0;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public void compare(final Box<T> b) {
        this.getWeight();
        b.getWeight();
    }

    public void layOut(final T fruit) {
        fruits.remove(fruit);
    }

    public void pourOver(final Box<? super T> b) {
        b.fruits.addAll(this.fruits);
        fruits.clear();
    }
}

