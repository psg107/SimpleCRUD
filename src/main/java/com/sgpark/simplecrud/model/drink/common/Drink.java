package com.sgpark.simplecrud.model.drink.common;

import lombok.Getter;
import lombok.Setter;

/**
 * 음료 정보
 */
public class Drink {
    /**
     * id
     */
    @Getter
    @Setter
    private int drinkId;

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

    /**
     * 음료 등록한 직원명
     */
    @Getter
    @Setter
    private String regEmployeeName;
}
