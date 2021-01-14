package exer2;

public class SubClassTest {
    public static void main(String[] args) {
        SubClass s = new SubClass();
        // 知识点1：接口的实现类可以调用接口中的默认方法
        s.method2();
        s.method3();
        // 知识点2：接口的静态方法只能接口本身调用
        CompareA.method1();
        // 知识点3：如果实现类中重写了接口的默认方法，则调用的是重写的方法
        s.method2();
        // 知识点4：父类优先原则：如果实现类的父类和接口中定义了一个同名且有相同参数类型的方法
        // 则默认调用的是父类的方法
        s.method3();
        // 知识点5：接口冲突：如果实现类的两个接口各定义了同名同参数的默认方法，则会引起接口冲突，实现类必须重写该方法

        s.myMehtod();
    }
}

class SubClass extends SuperClass implements CompareA,CompareB {
    public void method2() {
        System.out.println("SubClass:上海");
    }

    public void method3() {
        System.out.println("SubClass:武汉");
    }

    // 知识点6：实现类中如何调用接口中的默认方法
    public void myMehtod() {
        // 调用重写的方法
        method3();
        // 调用父类的方法
        super.method3();
        // 调用接口中的默认方法
        CompareA.super.method3();
    }
}
