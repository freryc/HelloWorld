/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer34;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * File类的使用
 *
 * @author z00440867
 * @since 2021-03-01
 */
public class FileTest {
    /**
     * File类的三种实例化方式
     * windows下的路径分隔符为：\\
     * linux下的路径分隔符为：/
     * 可以使用File类提供的一个常量public static final String separator来动态的提供分隔符
     * exp:"C:" + File.separator + xxx
     */
    @Test
    public void test1() {
        // 1.根据文件路径创建 public File(@NonNls @NotNull String pathname)
        File file1 = new File("Hello.txt");// 相对路径，相对于当前module
        File file2 = new File("C:\\Users\\z00440867\\IdeaProjects\\HelloWorld\\src\\exer34\\Hello.txt");// 绝对路径
        System.out.println(file1);
        System.out.println(file2);

        // 2.public File(@NonNls @Nullable String parent, @NonNls @NotNull String child)
        File file3 = new File("C:\\Users\\z00440867\\IdeaProjects\\HelloWorld\\src\\exer34", "Hello.txt");
        System.out.println(file3);

        // 3.public File(@Nullable File parent, @NonNls @NotNull String child)
        File file4 = new File(file3, "hi.txt");
        System.out.println(file4);
    }

    /**
     * File类的常见API
     */
    @Test
    public void test2() {
        File file1 = new File("C:\\Users\\z00440867\\IdeaProjects\\HelloWorld\\src\\exer34\\Hello.txt");
        // 1.获取绝对路径public String getAbsolutePath()
        System.out.println(file1.getAbsolutePath());

        // 2.获取路径public String getPath()
        System.out.println(file1.getPath());

        // 3.获取名称public String getName()
        System.out.println(file1.getName());

        // 4.获取上层文件路径 public String getParent()
        System.out.println(file1.getParent());

        // 5.获取文件长度（即字节数）。若无，返回null public long length()
        System.out.println(file1.length());

        // 6.获取最后一次的修改时间，毫秒数 public long lastModified()
        System.out.println(file1.lastModified());

        System.out.println();
        File file2 = new File("C:\\Users\\z00440867\\IdeaProjects\\HelloWorld\\src\\exer34");
        // 7.获取指定文件目录下的所有文件或者文件目录的名称数组
        String[] list = file2.list();
        for (String s : list) {
            System.out.println(s);
        }

        // 8.获取指定目录下的所有文件或者文件目录的File数组
        File[] files = file2.listFiles();
        for (File file : files) {
            System.out.println(file);
        }

    }

    @Test
    public void test3() {
        File file1 = new File("C:\\Users\\z00440867\\IdeaProjects\\HelloWorld\\src\\exer34\\Hello.txt");
        File file2 = new File("C:\\Users\\z00440867\\IdeaProjects\\HelloWorld\\src\\exer34\\hi.txt");

        // 9.文件的重命名public boolean renameTo(File dest)
        // 要想保证返回true，需要file1在硬盘中存在，且file2在硬盘中不能存在
        boolean renameTo = file1.renameTo(file2);
        System.out.println(renameTo);
    }

    @Test
    public void test4() {
        File file1 = new File("C:\\Users\\z00440867\\IdeaProjects\\HelloWorld\\src\\exer34\\hi.txt");
        // public boolean isDirectory()是否是一个文件目录
        System.out.println(file1.isDirectory());

        // public boolean isFile()是否是一个文件
        System.out.println(file1.isFile());

        // public boolean canRead()是否可读
        System.out.println(file1.canRead());

        // public boolean canWrite()是否可写
        System.out.println(file1.canWrite());

        // public boolean isHidden()是否隐藏文件
        System.out.println(file1.isHidden());
    }

    @Test
    public void test5() throws IOException {
        File file1 = new File("C:\\Users\\z00440867\\IdeaProjects\\HelloWorld\\src\\exer34\\dream.txt");

        // 文件的创建与删除  public boolean createNewFile()
        if (!file1.exists()) {
            file1.createNewFile();
        } else {
            file1.delete();
        }

        // 文件目录的创建public boolean mkdir() 创建文件目录，如果此文件目录存在，就不创建了，如果文件目录的上层目录不存在则创建失败
        File file2 = new File("D:\\io\\io1");
        boolean mkdir = file2.mkdir();
        if (mkdir) {
            System.out.println("文件目录创建成功");
        }

        // public boolean mkdirs() 创建文件目录，如果上层文件目录不存在，一并创建
        boolean mkdirs = file2.mkdirs();
        if (mkdirs) {
            System.out.println("文件目2录创建成功");
        }
    }
}
