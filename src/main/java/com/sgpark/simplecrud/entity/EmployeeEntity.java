package com.sgpark.simplecrud.entity;

import com.sgpark.simplecrud.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 직원 정보
 */
public class EmployeeEntity extends BaseEntity {
    /**
     * 직원명
     */
    @Getter
    @Setter
    private String name;

    public EmployeeEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
