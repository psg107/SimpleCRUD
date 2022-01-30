package com.sgpark.simplecrud.repository.base;

import com.sgpark.simplecrud.entity.base.BaseEntity;

import java.util.ArrayList;

public interface IRepositoryBase<T extends BaseEntity> {
    /**
     * CREATE
     * @param entity
     * @return
     */
    boolean insert(T entity);

    /**
     * Read All
     * @return
     */
    ArrayList<T> getAll();

    /**
     * Read Paging
     * @return
     */
    ArrayList<T> getWithPaging(int pageNumber, int pageSize);

    /**
     * Read One
     * @param id
     * @return
     */
    T getById(int id);

    /**
     * Update
     * @param entity
     * @return
     */
    boolean update(T entity);

    /**
     * Delete
     * @param id
     * @return
     */
    boolean delete(int id);
}
