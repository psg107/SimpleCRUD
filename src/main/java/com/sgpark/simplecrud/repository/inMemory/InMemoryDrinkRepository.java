package com.sgpark.simplecrud.repository.inMemory;

import com.sgpark.simplecrud.entity.DrinkEntity;
import com.sgpark.simplecrud.repository.inMemory.base.InMemoryRepositoryBase;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("TestInMemoryDrinkRepository")
public class InMemoryDrinkRepository extends InMemoryRepositoryBase<DrinkEntity> {

    public InMemoryDrinkRepository() {
        var testList = new ArrayList<DrinkEntity>();
        testList.add(new DrinkEntity(0, "아메리카노", 2500, 0));
        testList.add(new DrinkEntity(1, "비싼아메리카노", 4500, 2));
        testList.add(new DrinkEntity(2, "싼아메리카노", 500, 2));

        super.setInMemoryTestList(testList);
    }
}
