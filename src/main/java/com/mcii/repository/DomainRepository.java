package com.mcii.repository;

import java.io.Serializable;
import java.util.List;

import org.hibernate.query.Query;


public interface DomainRepository <T>{

	T get(Class<T> entity, int id);

    Serializable save(T entity);

    void update(T entity);

    void delete(T entity);

    Query<T> queryByHql(String hql);//根据hql语句查询,不分页

    Query queryByHql2(String hql);
}
