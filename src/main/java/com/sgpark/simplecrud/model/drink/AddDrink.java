package com.sgpark.simplecrud.model.drink;

public class AddDrink {
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

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    public int getRegEmployeeId() { return regEmployeeId; }

    public void setRegEmployeeId(int regEmployeeId) { this.regEmployeeId = regEmployeeId; }
}
