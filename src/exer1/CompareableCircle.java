package exer1;

public class CompareableCircle extends Circle implements CompareObject {
    public CompareableCircle(Double radius) {
        super(radius);
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }

        if (o instanceof CompareableCircle) {
            CompareableCircle c = (CompareableCircle)o;
            // 方式一
//            if (this.getRadius() > c.getRadius()) {
//                return 1;
//            } else if (this.getRadius() < c.getRadius()) {
//                return -1;
//            } else {
//                return 0;
//            }
            // 方式二 通过Double工具类提供的compareTo方法
            return (this.getRadius().compareTo(c.getRadius()));
        } else {
//            return 0;
            throw new RuntimeException("传入的数据类型不匹配");
        }
    }
}
