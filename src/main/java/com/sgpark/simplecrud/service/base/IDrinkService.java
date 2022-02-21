package com.sgpark.simplecrud.service.base;

import com.sgpark.simplecrud.model.common.Pagination;
import com.sgpark.simplecrud.model.drink.common.AddDrink;
import com.sgpark.simplecrud.model.drink.common.Drink;
import com.sgpark.simplecrud.model.drink.common.UpdateDrink;

public interface IDrinkService {

    /**
     * 음료 정보 가져오기
     * @return
     */
    Pagination<Drink> getDrinks(int pageNumber);

    /**
     * 특정 음료 정보 가져오기
     * @param drinkId
     * @return
     */
    Drink getDrink(int drinkId);

    /**
     * 음료 메뉴 추가
     * @param drink
     * @return
     */
    public boolean addDrink(AddDrink drink);

    /**
     * 음료 정보 수정
     * @param drink
     * @return
     */
    public boolean updateDrink(UpdateDrink drink);

    /**
     * 음료 정보 삭제
     * @param drinkId
     * @return
     */
    public boolean deleteDrink(int drinkId);
}
