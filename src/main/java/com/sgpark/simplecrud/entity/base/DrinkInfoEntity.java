package com.sgpark.simplecrud.entity.base;

/**
 * 음료 정보
 */
public class DrinkInfoEntity {
    /**
     * id
     */
    private int drinkId;

    /**
     * 메뉴명
     */
    private String name;

    /**
     * 가격
     */
    private int price;

    /**
     * 음료 등록한 직원ID
     */
    private int regEmployeeId;

    /**
     * 음료 등록한 직원명
     */
    private String regEmployeeName;

    public int getDrinkId() { return drinkId; }

    public void setDrinkId(int drinkId) {
        this.drinkId = drinkId;
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

    public String getRegEmployeeName() { return regEmployeeName; }

    public void setRegEmployeeName(String regEmployeeName) {
        this.regEmployeeName = regEmployeeName;
    }
}
