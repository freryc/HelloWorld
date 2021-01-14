package exer3;

import java.util.ArrayList;

/**
 * 类中的静态方法要想调用其他public方法，需要先在静态方法中new一个类对象
 */

public class StudentTest {
    public static void main(String[] args) {
        StudentTest studentTest = new StudentTest();
        Student[] students = new Student[20];

        // 实例化Student数组
        studentTest.initialStudentArray(students);

        // 遍历全部学生信息
        studentTest.print(students);

        System.out.println("******************************");

        // 打印3年级的学生信息
        studentTest.searchState(students, 3);

        System.out.println("******************************");

        // 使用冒泡排序
        studentTest.sort(students);
        studentTest.print(students);

        ArrayList arrayList = new ArrayList();
    }

    /**
     * 实例化Student数组
     */
    public void initialStudentArray(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].number = i + 1;
            students[i].state = (int)(Math.random() * (6 - 1 + 1)) + 1;
            students[i].score = (int)(Math.random() * (100 + 1));
        }
    }

    /**
     *
     * @param students 待打印的数组
     */
    public void print(Student[] students) {
        for (Student i : students) {
            i.getStudentInfo();
        }
    }

    /**
     *
     * @param students 待查找的数组
     * @param state 指定的年级
     */
    public void searchState(Student[] students, int state) {
        for (Student i : students) {
            if (i.state == 3) {
                i.getStudentInfo();
            }
        }
    }

    /**
     * 对数组进行冒泡排序
     * @param students 待排序的数组
     */
    public void sort(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < i; j++) {
                if (students[j].score > students[i].score) {
                    Student temp = students[j];
                    students[j] = students[i];
                    students[i] = temp;
                }
            }
        }
    }
}

class Student {
    int number;
    int state;
    int score;

    /**
     * 打印学生的信息
     */
    public void getStudentInfo() {
        System.out.println("学生的编号：" + number + "，年级：" + state + "，成绩分数：" + score);
    }
}