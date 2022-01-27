package com.sgpark.simplecrud.repository.mybatis;

import com.sgpark.simplecrud.entity.base.DrinkInfoEntity;
import com.sgpark.simplecrud.mapper.ISimpleCRUDMapper;
import com.sgpark.simplecrud.model.drink.AddDrink;
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

    public ArrayList<DrinkInfoEntity> getAllDrinkInfo() {
        var drinks1234 = mapper.getAllDrink();

        return null;
    }

    public DrinkInfoEntity getDrink(int drinkId) {
        var drink1234 = mapper.getDrink(drinkId);

        return null;
    }

    public boolean addDrinkInfo(AddDrink addDrinkInfo, int employeeId) {
        var aaa = mapper.addDrink();

        return false;
    }

    public boolean updateDrink(UpdateDrink drink, int employeeId) {
        var aaa = mapper.updateDrink();

        return false;
    }

    public boolean deleteDrink(int drinkId) {
        var aaa = mapper.deleteDrink();

        return false;
    }
}
