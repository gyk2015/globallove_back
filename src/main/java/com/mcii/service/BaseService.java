package com.mcii.service;

import java.io.Serializable;

public interface BaseService<T> {
    T get(Integer id);

    Serializable save(T entity);

    void delete(T entity);

    void update(T entity);

}
