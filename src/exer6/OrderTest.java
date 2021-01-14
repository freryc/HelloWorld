package exer6;

/**
 * @ClassName OrderTest
 * @Description TODO
 * @Author z00440867
 * @Date 2021/1/12 21:56
 * @Version 1.0
 */
public class OrderTest {
    public static void main(String[] args) {
        Order order1 = new Order(1);
        Order order2 = new Order(2);
        // 通过对象访问类的域变量
        System.out.println(order1.getId());
        System.out.println(order2.getId());

        // 通过对象访问类的静态方法，编译器支持通过对象访问静态变量、静态方法和静态常量，但是不提倡这样做，这样做很容易造成混淆
        System.out.println(order1.getNextId());
        System.out.println(order2.getNextId());

        // 通过类访问静态方法
        System.out.println(Order.getNextId());

        // 通过类访问静态常量
        System.out.println(Order.NUM);
        System.out.println(order1.NUM);
    }
}
