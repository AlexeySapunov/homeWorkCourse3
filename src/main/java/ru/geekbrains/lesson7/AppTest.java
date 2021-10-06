package ru.geekbrains.lesson7;

import java.lang.reflect.InvocationTargetException;

public class AppTest {
    public static void main(String[] args) {
        try {
            Tester.start(Tests.class);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
