package exer2;

/**
 * Java8以来新增接口中可以定义静态方法和默认方法
 */

public interface CompareA {
    // 静态方法
    static void method1() {
        System.out.println("CompareA:北京");
    }

    default void method2() {
        System.out.println("CompareA:上海");
    }

    /**
     * <一句话功能简述>.
     * <功能详细描述>
     *
     * @return void
     * @Param []
     * @remark create zhouxiaoke 2021年01月14日 需求/BUG编号
     * @see [类、类#方法、类#成员]
     */
    default void method3() {
        System.out.println("CompareA:武汉");
    }

    default void method4() {
        System.out.println("CompareA:成都");
    }
}
