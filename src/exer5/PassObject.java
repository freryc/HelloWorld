package exer5;

/**
 * @ClassName PassObject
 * @Description TODO
 * @Author z00440867
 * @Date 2021/1/11 19:37
 * @Version 1.0
 */
public class PassObject {
    public static void main(String[] args) {
        PassObject passObject = new PassObject();
        Circle circle = new Circle(0.0);
        passObject.printAreas(circle, 5);
        System.out.println("now radius is:" + (circle.radius + 1.0));
    }

    public void printAreas(Circle c, int time) {
        System.out.println("Radius\t\tArea");
        for (int i = 1; i <= time; i++) {
            c.radius = i;
            double area = c.findArea();
            System.out.println(c.radius + "\t\t" + area);
        }
    }
}
