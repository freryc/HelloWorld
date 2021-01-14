package com.horstmann.corejava;

public class Bird implements Flyable,Attackable, CC {
    @Override
    public void start() {
        System.out.println("Bird start fly!");
    }

    @Override
    public void stop() {
        System.out.println("Bird stop fly!");
    }


    @Override
    public void attackStart() {
        System.out.println("Bird start attack!");
    }

    @Override
    public void method1() {
        System.out.println("Implement AA method1");
    }

    @Override
    public void method2() {
        System.out.println("Implement BB method2");
    }

    @Override
    public void method3() {
        System.out.println("Implement CC method3");
    }
}
