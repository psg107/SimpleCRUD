package com.sgpark.simplecrud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
@Repository
public interface ISimpleCRUDMapper {
    ArrayList<HashMap<String, Object>> getAllDrink();

    HashMap<String, Object> getDrink(int drinkId);

    boolean addDrink();

    boolean updateDrink();

    boolean deleteDrink();
}
