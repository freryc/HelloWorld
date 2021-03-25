/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer7;

/**
 * 账户类
 *
 * @author z00440867
 * @since 2021-01-14
 */
public class Account {
    private double balance;

    /**
     * Account类的构造器
     *
     * @param balance 账户余额
     */
    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * 存款
     *
     * @param amt 待存入的金额
     */
    public void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            System.out.println("存入金额：" + amt);
        }
    }

    /**
     * 取款
     *
     * @param amt 待取金额
     */
    public void withdraw(double amt) {
        if (balance < amt) {
            System.out.println("余额不足");
        } else {
            balance -= amt;
            System.out.println("提取金额：" + amt + "，剩余金额：" + balance);
        }
    }
}
