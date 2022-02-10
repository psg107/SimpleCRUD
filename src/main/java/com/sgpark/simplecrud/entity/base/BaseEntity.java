package com.sgpark.simplecrud.entity.base;

import lombok.Getter;
import lombok.Setter;

/**
 * Int 타입의 키를 가지고 있는 Base Entity
 */
public abstract class BaseEntity {
    @Getter
    @Setter
    public int id;
}
