package com.sgpark.simplecrud.entity.base;

//#warning 편의상 무조건 키는 Int 타입
public abstract class BaseEntity {
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }
}
