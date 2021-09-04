package ru.geekbrains.lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        // 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);

        swap();

        // 2. Написать метод, который преобразует массив в ArrayList;

        arrayToList();
    }

    public static void swap() {
        final String[] str = {"abc", "bcd"};
        String s = str[0];
        str[0] = str[1];
        str[1] = s;
        System.out.println(Arrays.toString(str));
    }

    public static void arrayToList() {
        final String[] str = {"abc", "bcd"};
        final ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, str);
        for (String s : arrayList) {
            System.out.print(" " + s);
        }
    }

}
