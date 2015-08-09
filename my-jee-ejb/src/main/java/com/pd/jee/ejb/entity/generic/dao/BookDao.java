package com.pd.jee.ejb.entity.generic.dao;

import java.io.Serializable;
import java.util.Collection;

public interface BookDao<T extends Serializable> {
    boolean save(T entity);

    Collection<T> findAll();
}
