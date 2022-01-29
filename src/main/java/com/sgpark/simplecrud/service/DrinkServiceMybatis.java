package com.sgpark.simplecrud.service;

import com.sgpark.simplecrud.entity.DrinkEntity;
import com.sgpark.simplecrud.entity.EmployeeEntity;
import com.sgpark.simplecrud.model.drink.AddDrink;
import com.sgpark.simplecrud.model.drink.Drink;
import com.sgpark.simplecrud.model.drink.UpdateDrink;
import com.sgpark.simplecrud.repository.base.IRepositoryBase;
import com.sgpark.simplecrud.repository.mybatis.MybatisDrinkInfoRepository;
import com.sgpark.simplecrud.service.base.IDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
@Qualifier("DrinkServiceMybatis")
public class DrinkServiceMybatis implements IDrinkService {
    @Autowired
    @Qualifier("MybatisDrinkInfoRepository")
    private MybatisDrinkInfoRepository drinkInfoRepository;

    @Override
    public ArrayList<Drink> getAllDrink() {
        var drinks = this.drinkInfoRepository.getAllDrinkInfo();

        return drinks;
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
