package com.sgpark.simplecrud.entity;

import com.sgpark.simplecrud.entity.base.BaseEntity;

/**
 * 직원 정보
 */
public class EmployeeEntity extends BaseEntity {
    /**
     * 직원명
     */
    private String name;

    public EmployeeEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
