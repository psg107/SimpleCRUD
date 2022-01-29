package com.sgpark.simplecrud.repository.mybatis;

import com.sgpark.simplecrud.entity.base.DrinkInfoEntity;
import com.sgpark.simplecrud.mapper.ISimpleCRUDMapper;
import com.sgpark.simplecrud.model.drink.AddDrink;
import com.sgpark.simplecrud.model.drink.Drink;
import com.sgpark.simplecrud.model.drink.UpdateDrink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Qualifier("MybatisDrinkInfoRepository")
public class MybatisDrinkInfoRepository {
    @Autowired
    ISimpleCRUDMapper mapper;

    public ArrayList<Drink> getAllDrinkInfo() {
        var drinks = mapper.getAllDrink();

        return drinks;
    }

    public Drink getDrink(int drinkId) {
        var drink = mapper.getDrink(drinkId);

        return drink;
    }

    public boolean addDrinkInfo(AddDrink drink) {
        var added = mapper.addDrink(drink);

        return added;
    }

    public boolean updateDrink(UpdateDrink drink) {
        var updated = mapper.updateDrink(drink);

        return updated;
    }

    public boolean deleteDrink(int drinkId) {
        var deleted = mapper.deleteDrink(drinkId);

        return deleted;
    }
}
