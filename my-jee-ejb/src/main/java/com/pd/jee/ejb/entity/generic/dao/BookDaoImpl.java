package com.pd.jee.ejb.entity.generic.dao;

import java.util.Collection;

import javax.inject.Named;

@Named("bookDao")
public class BookDaoImpl extends AbstractJpaDao<Book, Long> implements BookDao<Book> {

    public BookDaoImpl() {
	super(Book.class);
    }

    @Override
    public boolean save(final Book entity) {
	super.persist(entity);

	return true;
    }

    @Override
    public Collection<Book> findAll() {
	return super.findAll();
    }
}
