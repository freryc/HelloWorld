package exer5;

/**
 * @ClassName Circle
 * @Description TODO
 * @Author z00440867
 * @Date 2021/1/11 19:33
 * @Version 1.0
 */
public class Circle {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea() {
        return Math.PI * radius * radius;
    }
}
