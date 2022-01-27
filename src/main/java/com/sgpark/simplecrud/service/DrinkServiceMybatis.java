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
        var drinks = this.drinkInfoRepository.getAllDrinkInfo().stream().map(x -> new Drink(){{
            var drinkId = x.getDrinkId();
            var name = x.getName();
            var price = x.getPrice();
            var regEmployeeId = x.getRegEmployeeId();

            setDrinkId((drinkId));
            setName(name);
            setPrice(price);
            setRegEmployeeId(regEmployeeId);
        }}).collect(Collectors.toCollection(ArrayList<Drink>::new));

        return drinks;
    }

    @Override
    public Drink getDrink(int drinkId) {
        var drinkInfoEntity = this.drinkInfoRepository.getDrink((drinkId));
        var drink = new Drink(){{
            var drinkId = drinkInfoEntity.getDrinkId();
            var name = drinkInfoEntity.getName();
            var price = drinkInfoEntity.getPrice();
            var regEmployeeId = drinkInfoEntity.getRegEmployeeId();

            setDrinkId((drinkId));
            setName(name);
            setPrice(price);
            setRegEmployeeId(regEmployeeId);
        }};

        return drink;
    }

    @Override
    public boolean addDrink(AddDrink drink, int employeeId) {
        var added = this.drinkInfoRepository.addDrinkInfo(drink, employeeId);

        return added;
    }

    @Override
    public boolean updateDrink(UpdateDrink drink, int employeeId) {
        var updated = this.drinkInfoRepository.updateDrink(drink, employeeId);

        return updated;
    }

    @Override
    public boolean deleteDrink(int drinkId) {
        var deleted = this.drinkInfoRepository.deleteDrink(drinkId);

        return deleted;
    }
}
