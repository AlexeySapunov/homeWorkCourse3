package ru.geekbrains.lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class Tester {

    public static void start(Class<?> clazz) throws InvocationTargetException, IllegalAccessException {
        Method beforeMethod = null;
        Method afterMethod = null;
        ArrayList<Method> testMethods = new ArrayList<>();

        Object instance = null;
        try {
            instance = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        final Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            } else if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeMethod == null) {
                    beforeMethod = method;
                } else {
                    throw new RuntimeException("Должно быть не более одного метода с аннотацией @BeforeSuite");
                }
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (afterMethod == null) {
                    afterMethod = method;
                } else {
                    throw new RuntimeException("Должно быть не более одного метода с аннотацией @AfterSuite");
                }
            }
        }

        if (beforeMethod != null) {
            beforeMethod.invoke(instance);
        }

        testMethods.sort(Comparator.comparingInt(o -> o.getAnnotation(Test.class).value()));
        for (Method method : testMethods) {
            method.invoke(instance);
        }

        if (afterMethod != null) {
            afterMethod.invoke(instance);
        }
    }
}
