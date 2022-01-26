package com.sgpark.simplecrud.repository.inMemory.base;

import com.sgpark.simplecrud.entity.base.BaseEntity;
import com.sgpark.simplecrud.repository.base.IRepositoryBase;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * InMemory 테스트를 위한 베이스 클래스
 * @param <T>
 */
public abstract class InMemoryRepositoryBase<T extends BaseEntity> implements IRepositoryBase<T> {
    private ArrayList<T> inMemoryTestList;

    public void setInMemoryTestList(ArrayList<T> inMemoryTestList){
        this.inMemoryTestList = inMemoryTestList;
    }

    @Override
    public boolean insert(T entity) {
        var newId = 0;

        var lastEntity = this.inMemoryTestList.stream()
                .max(Comparator.comparing(x -> x.getId()))
                .orElse(null);
        if (lastEntity != null){
            newId = lastEntity.getId() + 1;
        }

        entity.setId(newId);
        var added = this.inMemoryTestList.add(entity);

        return added;
    }

    @Override
    public ArrayList<T> getAll() {
        var output = new ArrayList<T>(this.inMemoryTestList);

        return output;
    }

    @Override
    public T getById(int id) {
        var entity = this.inMemoryTestList.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);

        return entity;
    }

    @Override
    public boolean update(T entity) {
        var id = entity.getId();

        var savedEntity = this.getById(id);
        if (savedEntity == null){
            return false;
        }

        var index = this.inMemoryTestList.indexOf(savedEntity);

        this.inMemoryTestList.set(index, entity);
        return true;
    }

    @Override
    public boolean delete(int id) {
        var deleted = this.inMemoryTestList.removeIf(x -> x.getId() == id);

        return deleted;
    }
}
