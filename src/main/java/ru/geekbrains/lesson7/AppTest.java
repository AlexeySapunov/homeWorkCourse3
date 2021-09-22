package ru.geekbrains.lesson7;

import java.lang.reflect.Method;

public class AppTest {
    public static void main(String[] args) {
        start(Tester.class);
    }

    public static void start(Class<?> clazz) {
        try {
            testClass(clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testClass(Class<?> clazz) {
        final Method[] methods = clazz.getMethods();
        try {
            int count1 = 0;
            for (Method method : methods) {

                if (method.getAnnotation(BeforeSuite.class) != null) {
                    if (count1 == 1) throw new TestException();
                    System.out.println(method);
                    count1++;
                }
            }
            for (int i = 1; i < 11; i++) {
                for (Method method : methods) {
                    if (method.getAnnotation(Test.class) != null) {
                        Test test = method.getAnnotation(Test.class);
                        if (test.value() == i) {
                            System.out.println(method);
                            System.out.println("value: " + test.value());
                        }
                    }
                }
            }
            int count2 = 0;
            for (Method method : methods) {
                if (method.getAnnotation(AfterSuite.class) != null) {
                    if (count2 == 1) throw new TestException();
                    System.out.println(method);
                    count2++;
                }
            }
        } catch (TestException e) {
            e.printStackTrace();
        }
    }
}
