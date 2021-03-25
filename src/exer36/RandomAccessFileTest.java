/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer36;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * RandomAccessFile类的使用
 * RandomAccessFile直接继承与java.lang.Object类，实现了DataInput和DataOutput接口
 * 特点：既可以作为一个输入流，也可以作为一个输出流，如何体现随机性，通过new对象时传参(r, rw, rwd, rws)决定
 *
 * @author z00440867
 * @since 2021-03-03
 */
public class RandomAccessFileTest {
    /**
     * RandomAccessFile既可以作为一个输入流，也可以作为一个输出流
     */
    @Test
    public void test1() {
        RandomAccessFile r = null;
        RandomAccessFile w = null;
        try {
            r = new RandomAccessFile("abc.jpg", "r");
            w = new RandomAccessFile(new File("C:\\Users\\z00440867\\IdeaProjects\\HelloWorld\\src\\exer36\\abc1.jpg"),
                "rw");

            byte[] buffer = new byte[1024];
            int len;

            while ((len = r.read(buffer)) != -1) {
                w.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (r != null) {
                    r.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (w != null) {
                    w.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * RandomAccessFile作为输出流，对文件的写入：
     * 如果文件不存在，则在写入过程中创建该文件
     * 如果文件存在，则默认从文件头开始覆盖
     */
    @Test
    public void test2() {
        RandomAccessFile rw = null;
        try {
            File file = new File(
                "\"C:\\\\Users\\\\z00440867\\\\IdeaProjects\\\\HelloWorld\\\\src\\\\exer36\\\\hello.txt\"");
            rw = new RandomAccessFile(file, "rw");
            rw.seek(3);// 将文件指针调到3的位置
            // rw.seek(file.length()); 可以实现从文件末尾的追加操作
            rw.write("123".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rw != null) {
                    rw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * java中i = j++;分为两步执行，第一步：i = j; 第二步：j++，即先赋值再++
     * 所以count=count++后count始终是零，只不过是第二个count混淆视听了，我们完全可以把它当做另一个不相关的变量。
     */
    @Test
    public void test3() {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            count = count++;
        }
        System.out.println(count);
    }

    @Test
    public void test4() {
        switch (5) {
            default:
                System.out.println(5);
            case 0:
                System.out.println(0);
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
        }
    }

    /**
     * 情况一：符合条件case语句中没有break
     * 输出：0 1 2
     * 结论：如果符合条件的case语句中没有break的话，后边的case将不做判断直接运行，直到遇见break跳出循环，
     * 否则顺序向下执行，default语句也会直接执行。
     */
    @Test
    public void test5() {
        int i = 0;
        switch (i) {
            case 0:
                System.out.println(0);
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
            default:
                System.out.println("default");
        }
    }

    /**
     * 情况二：符合条件case中有break
     * 输出：0
     * 结论：如果符合条件的case语句中有break，则直接调出循环
     */
    @Test
    public void test6() {
        int i = 0;
        switch (i) {
            case 0:
                System.out.println(0);
                break;
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
            default:
                System.out.println("default");
        }
    }

    /**
     * 情况三：符合条件case中没有break，但下一个case中有
     * 输出：0 1 2
     * 结论：如果符合条件的case语句中没有break的话，后边的case将不做判断直接运行，直到遇见break跳出循环。
     */
    @Test
    public void test7() {
        int i = 0;
        switch (i) {
            case 0:
                System.out.println(0);
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
                break;
            default:
                System.out.println("default");
        }
    }

    /**
     * 情况四：有符合条件的case，default语句放在最前边
     * 输出：0 1 2
     * 结论：switch结构中总是先匹配case，只有没有符合条件的case才会执行default语句，跟default语句的位置无关
     */
    @Test
    public void test8() {
        int i = 0;
        switch (i) {
            default:
                System.out.println("default");
            case 0:
                System.out.println(0);
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
                break;
        }
    }

    /**
     * 情况五：有符合条件的case，default语句放在最前边
     * 输出：0 1 2
     * 结论：switch结构中总是先匹配case，只有没有符合条件的case才会执行default语句，跟default语句的位置无关
     */
    @Test
    public void test9() {
        int i = 0;
        switch (i) {
            default:
                System.out.println("default");
            case 0:
                System.out.println(0);
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
        }
    }

    /**
     * 情况六：没有有符合条件的case，default语句放在最前边
     * 输出：default 0 1 2
     * 结论：switch结构中总是先匹配case，只有没有符合条件的case才会执行default语句，跟default语句的位置无关
     */
    @Test
    public void test10() {
        int i = 5;
        switch (i) {
            default:
                System.out.println("default");
            case 0:
                System.out.println(0);
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
        }
    }

    @Test
    public void test11() {
        char a = 'A';
        int foo = 65;
        boolean trueExp = true;
        System.out.println(trueExp ? a : 0);
        System.out.println(trueExp ? a : foo);

        int[] nums = {21, 2, 3, 4};
        System.out.println(nums);

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(12);
        integers.add(23);
        integers.add(56);
        System.out.println(integers);
    }

    @Test
    public void test12() {
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        System.out.println(strings.getClass());
        System.out.println(integers.getClass());

    }

    @Test
    public void test13() {
        String str = "123";
        String s2 = str + 456;
        System.out.println(s2);
    }
}
