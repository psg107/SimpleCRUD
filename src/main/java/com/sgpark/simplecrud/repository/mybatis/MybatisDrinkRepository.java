package com.sgpark.simplecrud.repository.mybatis;

import com.sgpark.simplecrud.entity.DrinkEntity;
import com.sgpark.simplecrud.repository.base.IRepositoryBase;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

//#warning 마이바티스인가 이거 어떻게 쓰는거지
/**
 *
 */
@Component("MybatisDrinkRepository")
public class MybatisDrinkRepository implements IRepositoryBase<DrinkEntity> {
    @Override
    public boolean insert(DrinkEntity entity) {
        return false;
    }

    @Override
    public ArrayList<DrinkEntity> getAll() {
        return null;
    }

    @Override
    public DrinkEntity getById(int id) {
        return null;
    }

    @Override
    public boolean update(DrinkEntity entity) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
