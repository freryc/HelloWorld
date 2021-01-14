import java.io.PrintStream;
import java.util.Arrays;

/**
 * @ClassName Test
 * @Description TODO
 * @Author z00440867
 * @Date 2021/1/11 17:23
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        // 需要在myMethod方法被调用后，仅打印出a=100，b=200。请写出myMethod方法的代码
        int a = 10;
        int b = 10;

        myMethod1(a, b);

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("args = " + Arrays.deepToString(args));
        System.out.println("Test.main");
        System.out.println("b = " + b);
    }

    /**
     *
     * @param a
     * @param b
     */
    public static void myMethod1(int a, int b) {
        a = 100;
        b = 200;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.exit(0);
    }

    /**
     *
     * @param a
     * @param b
     */
    public static void myMethod2(int a, int b) {
        PrintStream ps = new PrintStream(System.out) {
          @Override
          public void println(String x) {
              if ("a = 10".equals(x)) {
                  x = "a = 100";
              } else if ("b = 10".equals(x)) {
                  x = "b = 200";
              }
              super.println(x);
          }
        };
        System.setOut(ps);
    }
}

class Student {
    private int num;
    private double score;


    Test test = new Test();

    Student(int num, double score) {
        this.num = num;
        this.score = score;
    }

    public Student() {

    }
}

class StudentTest {
    Student student = new Student();

}
