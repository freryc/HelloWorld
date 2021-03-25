/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer26;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * description
 *
 * @author z00440867
 * @since 2021-02-08
 */
public class PictureCopyTest {
    @Test
    public void test1() throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            // 1.实例化文件对象
            File file1 = new File("abc.jpg");
            File file2 = new File("abc2.jpg");
            // 2.实例化流对象
            fileInputStream = new FileInputStream(file1);
            fileOutputStream = new FileOutputStream(file2);
            // 读写操作
            int len;
            byte[] bytes = new byte[10];
            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } finally {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            }
        }

    }

    @Test
    public void test2() {
        ArrayList<Integer> integers = new ArrayList<>();
        int[] ints = {1, 2, 3, 4, 5};
        // for (int i : ints) {
        //     i = 10;
        // }

        for (int i = 0; i < ints.length; i++) {
            ints[i] = 10;
        }
        System.out.println(Arrays.toString(ints));
    }
}
