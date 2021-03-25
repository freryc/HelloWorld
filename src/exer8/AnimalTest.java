/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer8;

/**
 * 类的多态性学习
 * 1.理解多态性：可以理解为一个事物的多种形态
 * 2.何为多态性
 * 对象的多态性：父类的引用指向子类的对象（父类 父类的引用 = new 子类）
 * 3.多态的使用：虚拟方法调用
 * 有了对象的多态性以后，我们在编译期，只能调用父类的方法，但在运行期，实际执行的是子类重写父类的方法
 * 总结：编译看左边，运行看右边。
 * 4.多态性的使用前提：①类的继承关系；②方法的重写
 * 5.对象的多态性，只适用于方法，不适用于属性（编译和运行多看左边）
 *
 * @author z00440867
 * @since 2021-01-16
 */
public class AnimalTest {
    public static void main(String[] args) {
        AnimalTest animalTest = new AnimalTest();
        Animal animal = new Dog();
        animalTest.test(animal);

        // 有了类的多态性后，内存中实际是加载了子类特有的属性和方法的，但是由于变量类型声明为父类类型，
        // 导致编译时，只能调用父类中声明的属性和方法。子类特有的属性和方法不能调用。

        // 如何才能调用子类特有的属性和方法呢？
        // 向下转型：使用强制类型转换符，将父类的引用转换为子类的应用
        // 向上转型：即多态
        Dog dog = (Dog) animal;
        dog.showAge(100, 12.5);

        // 使用强制类型转换时，可能出现ClassCastException的异常
        // Cat cat = (Cat) animal;
        // cat.eat();

        // 那么我们如何确定可以使用强制类型转换呢？答案：使用instanceof
        /*
         * a instanceof A:判断对象a是否是类A的实例。如果是，返回true；不是，返回false。
         *
         * 使用场景：为了避免在向下转型时出现ClassCastException的异常，我们先进行instanceof判断
         */
        if (animal instanceof Cat) {
            System.out.println("animal is a kind of Cat");
        }
    }

    public void test(Animal animal) {
        // 多态性：实际执行的是子类重写父类的方法
        animal.eat();
        animal.walk();
        // 多态性只适用于方法，不适用于属性，这时候调用的仍然是父类的属性
        System.out.println(animal.id);

        animal.showAge(10);
    }
}
