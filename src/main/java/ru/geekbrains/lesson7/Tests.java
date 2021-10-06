package ru.geekbrains.lesson7;

public class Tests {

    @BeforeSuite
    private void beforeTest(){
        System.out.println("Before test");
    }

    @Test (value = 3)
    public void test4(){
        System.out.println("Test 4");
    }

    @Test(value = 1)
    public void test1(){
        System.out.println("Test 1");
    }

    @Test(value = 2)
    public void test2(){
        System.out.println("Test 2");
    }

    @Test (value = 2)
    public void test3(){
        System.out.println("Test 3");
    }

    @AfterSuite
    private void afterTest() { System.out.println("After test"); }
}
