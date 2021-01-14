package com.horstmann.corejava;

/*
* 接口的使用
* 1.接口使用interface关键字来定义；
* 2.Java中接口和类是并列的两个结构
* 3.如何定义接口，定义接口中的成员
*
*       3.1 JDK7及以前：只能定义全局变量和抽象方法
*           >全局常量：类型默认为public static final，可省略
*           >抽象方法：类型默认为public abstract，可省略
* 4.接口中不能定义构造器！意味着接口不能实例化
* 5.Java开发中，接口通常让类去实现（implements）的方式来使用；
*   如果实现类覆盖了接口中的所有抽象方法，则此实现类可以被实例化
*   如果实现类没有覆盖接口中的所有抽象方法，则此实现类仍然为一个抽象类
* 6.IDEA快捷键：快速构造接口的实现类，鼠标停在接口名称处，按“ALT+ENTER”选择“Implements interface”
* 7.Java类可以实现多个接口  --->弥补了Java单继承性的局限性
* 格式：class AA extends BB implements CC,DD,EE
* 8.接口和接口之间可以继承，而且支持多继承
* **************************************
* 9.接口的具体使用，体现多态性
* 10.接口，实际上可以看做一种规范（“如果你是/要...，就必须会/能...”）
**/

public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIN_SPEED);

        Bird bird = new Bird();
        bird.start();
        bird.stop();
        bird.attackStart();
        bird.method1();
        bird.method2();
        bird.method3();
    }

    private void myMethod() {
        System.out.println("haha");
    }
}

interface Flyable {
    public static final int MAX_SPEED = 1000;
    int MIN_SPEED = 1;

    public abstract void start();
    void stop();
}

interface Attackable {
    void attackStart();
}

interface AA {
    void method1();
}

interface BB {
    void method2();
}

interface CC extends AA, BB {
    void method3();
}