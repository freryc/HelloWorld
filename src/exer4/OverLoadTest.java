package exer4;

/**
 * *@ClassName OverLoadTest
 * *@Description 函数的重载
 * *@Author z00440867
 * *@Date 2021/1/7 15:42
 * *@Version 1.0
 **/

public class OverLoadTest {
    public static void main(String[] args) {
        OverLoad overLoad = new OverLoad();
        overLoad.mOL(3);
        overLoad.mOL(3, 4);
        overLoad.mOL("abc");

        int max = overLoad.max(3, 4);
        System.out.println(max);
        double max2 = overLoad.max(3.5, 4.1);
        System.out.println(max2);
    }
}

class OverLoad {
    public void mOL(int i) {
        System.out.println(i * i);
    }

    public void mOL(int i, int j) {
        System.out.println(i * j);
    }

    public void mOL(String str) {
        System.out.println(str);
    }

    public int max(int i, int j) {
        return i >= j ? i : j;
    }

    public double max(double i, double j) {
        return i >= j ? i : j;
    }

//    public double max(double i, double j, double k) {
//        double[] arr = new double[]{i, j, k};
//        arr
//
//    }

}
