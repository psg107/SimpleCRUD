package com.sgpark.simplecrud.mapper;

import com.sgpark.simplecrud.entity.DrinkEntity;
import com.sgpark.simplecrud.model.drink.AddDrink;
import com.sgpark.simplecrud.model.drink.Drink;
import com.sgpark.simplecrud.model.drink.UpdateDrink;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
@Repository
public interface ISimpleCRUDMapper {
    ArrayList<Drink> getAllDrink();

    Drink getDrink(int drinkId);

    boolean addDrink(AddDrink drink);

    boolean updateDrink(UpdateDrink drink);

    boolean deleteDrink(int drinkId);
}
