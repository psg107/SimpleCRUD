package com.sgpark.simplecrud.service;

import com.sgpark.simplecrud.model.common.PagingList;
import com.sgpark.simplecrud.model.drink.AddDrink;
import com.sgpark.simplecrud.model.drink.Drink;
import com.sgpark.simplecrud.model.drink.UpdateDrink;
import com.sgpark.simplecrud.repository.mybatis.MybatisDrinkInfoRepository;
import com.sgpark.simplecrud.service.base.IDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Qualifier("DrinkServiceMybatis")
public class DrinkServiceMybatis implements IDrinkService {

    private final MybatisDrinkInfoRepository drinkInfoRepository;

    @Autowired
    public DrinkServiceMybatis(@Qualifier("MybatisDrinkInfoRepository")MybatisDrinkInfoRepository drinkInfoRepository) {
        this.drinkInfoRepository = drinkInfoRepository;
    }

    @Override
    public ArrayList<Drink> getAllDrinks() {
        var drinks = this.drinkInfoRepository.getAllDrinks();

        return drinks;
    }

    @Override
    public PagingList<Drink> getDrinksWithPaging(int pageNumber, int pageSize) {
        var itemCount = this.drinkInfoRepository.getDrinkCount();
        var drinks = this.drinkInfoRepository.getDrinksWithPaging(pageNumber, pageSize);

        var pagingDrinks = new PagingList<Drink>(pageNumber, itemCount, drinks);

        return pagingDrinks;
    }

    @Override
    public Drink getDrink(int drinkId) {
        var drink = this.drinkInfoRepository.getDrink(drinkId);

        return drink;
    }

    @Override
    public boolean addDrink(AddDrink drink) {
        var added = this.drinkInfoRepository.addDrinkInfo(drink);

        return added;
    }

    @Override
    public boolean updateDrink(UpdateDrink drink) {
        var updated = this.drinkInfoRepository.updateDrink(drink);

        return updated;
    }

    @Override
    public boolean deleteDrink(int drinkId) {
        var deleted = this.drinkInfoRepository.deleteDrink(drinkId);

        return deleted;
    }
}
