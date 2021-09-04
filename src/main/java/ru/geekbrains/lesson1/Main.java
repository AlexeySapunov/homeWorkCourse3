package ru.geekbrains.lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main<T> {
    public static void main(String[] args) {

        // 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
        final String[] strings = {"abc", "def"};
        System.out.println(Arrays.toString(strings));
        final Main<Object> main = new Main<>();
        main.swap(strings, 0, 1);
        System.out.println(Arrays.toString(strings));

        // 2. Написать метод, который преобразует массив в ArrayList;

        List<String> arrList = arrayToList(strings);
        System.out.println(arrList);
    }

    public void swap(final T[] arr, int a, int b) {
        final T swap = arr[a];
        arr[a] = arr[b];
        arr[b] = swap;
    }

    public static <T> ArrayList<T> arrayToList(T[] arrList) {
        return new ArrayList<>(Arrays.asList(arrList));
    }

}
