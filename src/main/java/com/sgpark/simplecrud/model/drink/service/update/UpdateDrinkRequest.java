package com.sgpark.simplecrud.model.drink.service.update;

import com.sgpark.simplecrud.model.common.service.IRequestBase;
import lombok.Getter;
import lombok.Setter;

public class UpdateDrinkRequest implements IRequestBase {
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
     * 음료 등록한 사용자 ID
     */
    @Getter
    @Setter
    private int regMemberId;
}
