package com.horstmann.corejava;

/**
 * 接口的使用
 * 1.接口的使用上满足多态性
 * 2.接口实际上就是定义了一组规范
 * 3.开发中，体会面向接口编程
 */

public class UsbTest {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // 1.创建了接口的非匿名实现类的非匿名对象
        Computer computer = new Computer();
        Printer printer = new Printer();

        computer.transferData(printer);

        // 2.创建了接口的非匿名实现类的匿名对象
        computer.transferData(new Printer());

        // 3.创建了接口的匿名实现类的非匿名对象
        USB usb = new USB() {
            @Override
            public void start() {
                System.out.println("手机开始工作！");
            }

            @Override
            public void stop() {
                System.out.println("手机开始工作！");
            }
        };
        computer.transferData(usb);

        // 4.创建了接口的匿名实现类的匿名对象
        computer.transferData(new USB() {
            @Override
            public void start() {
                System.out.println("键盘开始工作！");
            }

            @Override
            public void stop() {
                System.out.println("键盘开始工作！");
            }
        });

    }
}

class Computer {
    public void transferData(USB usb) {
        usb.start();
        System.out.println("具体的传输数据逻辑");
        usb.stop();
    }
}

class Printer implements USB {

    @Override
    public void start() {
        System.out.println("打印机开始工作！");
    }

    @Override
    public void stop() {
        System.out.println("打印机结束工作！");
    }
}

interface USB {
    void start();

    void stop();
}
