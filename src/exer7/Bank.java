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
public class Bank {
    private Customer[] customers;

    private int numberOfCustomer;

    /**
     * Bank类构造器
     */
    public Bank() {

    }

    /**
     * Bank类的构造器
     *
     * @param customers 客户类型的数组
     * @param numberOfCustomer 实际客户的数量
     */
    public Bank(Customer[] customers, int numberOfCustomer) {
        this.customers = customers;
        this.numberOfCustomer = numberOfCustomer;
    }

    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }

    /**
     * 添加客户
     *
     * @param firstName 客户的姓
     * @param lastName 客户的名
     */
    public void addCustomer(String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName);
        customers[numberOfCustomer] = customer;
        numberOfCustomer += 1;
    }

    /**
     * 返回对应序号的客户
     *
     * @param index 待查找的客户序号
     * @return 待查找的客户对象
     */
    public Customer getCustomer(int index) {
        if (index >= 0 && index < numberOfCustomer) {
            return customers[index];
        } else {
            return null;
        }
    }

}
