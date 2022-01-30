package com.sgpark.simplecrud.modelBuilder;

import com.sgpark.simplecrud.entity.DrinkEntity;
import com.sgpark.simplecrud.entity.EmployeeEntity;
import com.sgpark.simplecrud.model.drink.Drink;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 */
public class DrinkListBuilder {
    private ArrayList<DrinkEntity> drinkEntities;
    private ArrayList<EmployeeEntity> employeeEntities;
    private Integer pageNumber;
    private Integer pageSize;

    /**
     *
     * @param drinkEntities
     * @return
     */
    public DrinkListBuilder setDrinkEntities(ArrayList<DrinkEntity> drinkEntities){
        this.drinkEntities = drinkEntities;
        return this;
    }

    /**
     *
     * @param employeeEntities
     * @return
     */
    public DrinkListBuilder setEmployeeEntities(ArrayList<EmployeeEntity> employeeEntities){
        this.employeeEntities = employeeEntities;
        return this;
    }

    /**
     *
     * @param pageNumber
     * @return
     */
    public DrinkListBuilder setPageNumber(int pageNumber){
        this.pageNumber = pageNumber;
        return this;
    }

    /**
     *
     * @param pageSize
     * @return
     */
    public DrinkListBuilder setPageSize(int pageSize){
        this.pageSize = pageSize;
        return this;
    }

    /**
     *
     * @return
     */
    public ArrayList<Drink> buildDrinkList(){

        Stream<Drink> drinkStream = drinkEntities.stream()
                .flatMap(d -> employeeEntities.stream()
                        .filter(e -> d.getRegEmployeeId() == e.getId())
                        .map(e -> Map.entry(d, e))
                ).map(x -> new Drink(){{
                    var drink = x.getKey();
                    var employee = x.getValue();

                    setDrinkId(drink.getId());
                    setName(drink.getName());
                    setPrice(drink.getPrice());
                    setRegEmployeeId(employee.getId());
                    setRegEmployeeName(employee.getName());
                }});

        if (this.pageNumber != null && this.pageSize != null){
            drinkStream = drinkStream
                    .skip((pageNumber - 1) * pageSize)
                    .limit(pageSize);
        }

        var drinkList = drinkStream.collect(Collectors.toCollection(ArrayList<Drink>::new));

        return drinkList;
    }
}
