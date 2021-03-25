/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer32;

import java.io.Serial;
import java.io.Serializable;

/**
 * description
 *
 * @author z00440867
 * @since 2021-02-26
 */
public class Creature<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1703820334039122361L;

    private char gender;

    public double weight;

    private void breath() {
        System.out.println("生物呼吸");
    }

    public void eat() {
        System.out.println("生物吃东西");
    }
}
