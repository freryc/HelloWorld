/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer7;

/**
 * description
 *
 * @author z00440867
 * @since 2021-01-14
 */
public class BankTest {
    public static final int CUSTOMERS_NUM = 10;

    /**
     * main方法
     *
     * @param args 参数列表
     */
    public static void main(String[] args) {
        Customer[] customers = new Customer[CUSTOMERS_NUM];
        Bank bank = new Bank(customers, 0);

        bank.addCustomer("zhou", "xiaoke");
        System.out.println(bank.getNumberOfCustomer());
        bank.addCustomer("zhou", "dake");
        System.out.println(bank.getNumberOfCustomer());
        bank.addCustomer("xiao", "mi");
        System.out.println(bank.getNumberOfCustomer());
        System.out.println(bank.getCustomer(1).getLastName());

        bank.getCustomer(0).setAccount(new Account(2000));
        bank.getCustomer(0).getAccount().withdraw(200);
        System.out.println(bank.getCustomer(0).getAccount().getBalance());
    }
}
