package com.sgpark.simplecrud.service.base;

import com.sgpark.simplecrud.model.drink.AddDrink;
import com.sgpark.simplecrud.model.drink.Drink;
import com.sgpark.simplecrud.model.drink.UpdateDrink;

import java.util.ArrayList;

public interface IDrinkService {
    /**
     * 모든 음료 정보 가져오기
     * @return
     */
    ArrayList<Drink> getAllDrink();
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
    public boolean addDrink(AddDrink drink, int employeeId);

    /**
     * 음료 정보 수정
     * @param drink
     * @param employeeId
     * @return
     */
    public boolean updateDrink(UpdateDrink drink, int employeeId);

    /**
     * 음료 정보 삭제
     * @param drinkId
     * @return
     */
    public boolean deleteDrink(int drinkId);
}
