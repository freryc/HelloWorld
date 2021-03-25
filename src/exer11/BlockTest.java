/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer11;

/**
 * description
 *
 * @author z00440867
 * @since 2021-01-19
 */
public class BlockTest {
    public static void main(String[] args) {
        Block block = new Block();
    }
}

class Block {
    static {
        System.out.println("这是静态代码块");
    }

    {
        System.out.println("这是普通代码块");
    }

    public Block() {
        System.out.println("这是无参构造器");
    }
}