package com.sgpark.simplecrud.entity.base;

/**
 * Int 타입의 키를 가지고 있는 Base Entity
 */
public abstract class BaseEntity {
    public int id;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }
}
