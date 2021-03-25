/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer13;

/**
 * 抽象类在模板方法中的应用
 *
 * @author z00440867
 * @since 2021-01-20
 */
public class TemplateTest {
    public static void main(String[] args) {
        SubTemplate1 s1 = new SubTemplate1();
        SubTemplate2 s2 = new SubTemplate2();

        s1.work();
        s2.work();
    }
}

abstract class Template {
    public void work() {
        prepare();

        doWork();

        conclude();
    }

    private void prepare() {
        System.out.println("工作前准备");
    }

    public abstract void doWork();

    private void conclude() {
        System.out.println("工作后总结知识");
    }
}

class SubTemplate1 extends Template {

    @Override
    public void doWork() {
        System.out.println("coding");
    }
}

class SubTemplate2 extends Template {

    @Override
    public void doWork() {
        System.out.println("eating");
    }
}