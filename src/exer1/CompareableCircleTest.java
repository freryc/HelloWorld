package exer1;

class CompareableCircleTest {

    public static void main(String[] args) {
        CompareableCircle c1 = new CompareableCircle(3.4);
        CompareableCircle c2 = new CompareableCircle(3.4);

        int compareValue = c1.compareTo(c2);
        if (compareValue > 0) {
            System.out.println("c1对象大");
        } else if (compareValue < 0) {
            System.out.println("c2对象大");
        } else {
            System.out.println("c1、c2一样大");
        }
    }
}