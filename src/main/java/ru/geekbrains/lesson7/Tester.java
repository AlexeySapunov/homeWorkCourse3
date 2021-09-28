package ru.geekbrains.lesson7;

public class Tester {

    @BeforeSuite
    public void beforeTest(){
        System.out.println("Before test");
    }

    @Test (5)
    public void test5(){
        System.out.println("Test 5");
    }

    @Test(1)
    public void test1(){
        System.out.println("Test 1");
    }

    @Test(2)
    public void test2(){
        System.out.println("Test 2");
    }

    @Test (7)
    @AfterSuite
    public void test3(){
        System.out.println("Test 3");
    }

    @AfterSuite
    public void afterTest() { System.out.println("After test"); }
}
