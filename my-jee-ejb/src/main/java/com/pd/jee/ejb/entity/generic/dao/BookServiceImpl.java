package com.pd.jee.ejb.entity.generic.dao;

import java.util.Collection;

import javax.ejb.*;
import javax.inject.Inject;

import com.pd.jee.api.BookServiceLocal;

@Stateless
@Local(BookServiceLocal.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class BookServiceImpl implements BookServiceLocal<Book> {

    @Inject
    private BookDao<Book> bookDao;

    @Override
    public boolean save(final Book contact) {
	return bookDao.save(contact);
    }

    @Override
    public Collection<Book> findAll() {
	return bookDao.findAll();
    }

}
