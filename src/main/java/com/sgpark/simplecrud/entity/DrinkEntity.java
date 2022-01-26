package com.sgpark.simplecrud.entity;

import com.sgpark.simplecrud.entity.base.BaseEntity;
import com.sgpark.simplecrud.model.DrinkInfo;

/**
 * 음료 정보
 * @see DrinkInfo
 */
public class DrinkEntity extends BaseEntity {
    /**
     * 메뉴명
     */
    private String name;

    /**
     * 가격
     */
    private int price;

    /**
     * 음료 등록한 직원 ID
     */
    private int regEmployeeId;

    public DrinkEntity(int id, String name, int price, int regEmployeeId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.regEmployeeId = regEmployeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRegEmployeeId() {
        return regEmployeeId;
    }

    public void setRegEmployeeId(int regEmployeeId) {
        this.regEmployeeId = regEmployeeId;
    }
}
