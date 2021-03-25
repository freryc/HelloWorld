/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer16;

/**
 * throw、throws
 * ctrl+alt+t：surround with快捷键
 * 如何自定义异常类：
 * 1.继承与现有的异常结构：RuntimeException、Exception
 * 2.提供全局常量：serialVersionUID
 * 3.提供重载的构造器
 *
 * @author z00440867
 * @since 2021-01-21
 */
public class ThrowTest {
    public static void main(String[] args) {
        ThrowTest throwTest = new ThrowTest();
        try {
            throwTest.method(-1);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public void method(int number) throws MyException {
        if (number > 0) {
            System.out.println(number);
        } else {
            throw new MyException("输入的数字小于0");
        }
    }
}

class MyException extends Exception {
    static final long serialVersionUID = -3387516993124229984L;

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}