package com.sgpark.simplecrud.utils.base;

import com.sgpark.simplecrud.entity.base.BaseEntity;

public abstract class BaseModelMapper<T1 extends BaseEntity, T2> {
    public abstract T1 map(T2 item);

    public abstract T2 map(T1 item);
}
