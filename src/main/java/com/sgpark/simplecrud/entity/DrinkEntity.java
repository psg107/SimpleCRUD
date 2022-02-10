package com.sgpark.simplecrud.entity;

import com.sgpark.simplecrud.entity.base.BaseEntity;
import com.sgpark.simplecrud.model.drink.Drink;
import lombok.Getter;
import lombok.Setter;

/**
 * 음료 정보
 * @see Drink
 */
public class DrinkEntity extends BaseEntity {
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
     * 음료 등록한 직원 ID
     */
    @Getter
    @Setter
    private int regEmployeeId;

    public DrinkEntity(int id, String name, int price, int regEmployeeId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.regEmployeeId = regEmployeeId;
    }

    public DrinkEntity(String name, int price, int regEmployeeId) {
        this.name = name;
        this.price = price;
        this.regEmployeeId = regEmployeeId;
    }
}
