package com.sgpark.simplecrud.model.drink.common;

import lombok.Getter;
import lombok.Setter;

public class AddDrink {
    /**
     * 메뉴명
     */
    @Getter
    @Setter
    private String name;

    /**
     * 가격
     */
    @Getter
    @Setter
    private int price;

    /**
     * 음료 등록한 직원ID
     */
    @Getter
    @Setter
    private int regEmployeeId;
}
