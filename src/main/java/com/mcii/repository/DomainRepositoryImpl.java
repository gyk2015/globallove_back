package com.mcii.repository;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DomainRepositoryImpl<T> implements DomainRepository<T> {

    @Autowired
    private SessionFactory sessionFactory;
    
    

    @Override
    public T get(Class<T> clazz, int id) {
        Session session = sessionFactory.getCurrentSession();
        Serializable entity = (Serializable) session.get(clazz, id);
        return (T) entity;
    }

    @Override
    public Serializable save(T entity) {
        Session session = sessionFactory.getCurrentSession();
        Serializable object = (Serializable) session.save(entity);
        return object;
    }

    @Override
    public void update(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }

    @Override
    public void delete(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(entity);
    }

    @Override
    public Query<T> queryByHql(String hql) {
        Session session = sessionFactory.getCurrentSession();
        Query<T> query = session.createQuery(hql);
        return query;
    }

    @Override
    public Query queryByHql2(String hql) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        return query;
    }
}
