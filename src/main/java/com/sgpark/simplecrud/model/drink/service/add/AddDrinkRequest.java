package com.sgpark.simplecrud.model.drink.service.add;

import com.sgpark.simplecrud.model.common.service.IRequestBase;
import lombok.Getter;
import lombok.Setter;

public class AddDrinkRequest implements IRequestBase {
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
}
