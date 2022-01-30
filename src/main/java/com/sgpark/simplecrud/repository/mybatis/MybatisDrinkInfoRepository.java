package com.sgpark.simplecrud.repository.mybatis;

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

    private final ISimpleCRUDMapper mapper;

    @Autowired
    public MybatisDrinkInfoRepository(ISimpleCRUDMapper mapper) {
        this.mapper = mapper;
    }

    public int getDrinkCount() {
        var count = mapper.getDrinkCount();

        return count;
    }

    public ArrayList<Drink> getAllDrinks() {
        var drinks = mapper.getAllDrinks();

        return drinks;
    }

    public ArrayList<Drink> getDrinksWithPaging(int pageNumber, int pageSize) {
        var drinks = mapper.getDrinksWithPaging((pageNumber - 1) * pageSize, pageSize);

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
