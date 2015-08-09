package com.pd.jee.api;

import java.io.Serializable;
import java.util.Collection;

public interface BookServiceLocal<T extends Serializable> {
    boolean save(T entity);

    Collection<T> findAll();
}
