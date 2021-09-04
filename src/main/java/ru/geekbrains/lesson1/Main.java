package ru.geekbrains.lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
        final String[] strings = {"abc", "def"};
        System.out.println(Arrays.toString(strings));
        swap(strings, 0, 1 );

        // 2. Написать метод, который преобразует массив в ArrayList;

        List<String> arrList = arrayToList(strings);
        System.out.println(arrList);
    }

    public static void swap(final String[] str, int a, int b) {
        final String strings = str[a];
        str[a] = str[b];
        str[b] = strings;
        System.out.println(Arrays.toString(str));
    }

    public static <T> ArrayList<T> arrayToList(T[] arrList) {
        return new ArrayList<T>(Arrays.asList(arrList));
    }

}
