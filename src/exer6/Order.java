package exer6;

/**
 * @ClassName Order
 * @Description TODO
 * @Author z00440867
 * @Date 2021/1/12 21:51
 * @Version 1.0
 * Java有四种权限修饰符private、缺省、protected、public，这四种权限修饰符可以修饰类和类的成员（属性、方法、构造器）
 * 类的权限修饰符只有两种：缺省和public
 * 类的缺省权限是只能类所在的包内可以new
 * 类的public权限是不同包可以new对象
 */
class Order {
    private int id;
    private static int nextId = 0;
    public static double NUM = 12.5;

    public Order(int id) {
        this.id = id;
        nextId++;
    }

    public Order() {
        nextId++;
    }

    public static int getNextId() {
        return nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
