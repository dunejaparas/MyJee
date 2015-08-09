package com.pd.jee.ejb;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.pd.jee.ejb.entity.generic.dao.Book;
import com.pd.jee.ejb.entity.generic.dao.BookDao;

@Singleton
@Startup
@ApplicationScoped
/**
 @Stateless 	ERROR	- A component named 'MySingletonSLSB' is already defined in this module

 @RequestScoped ERROR	- RequestScoped is not allowed on singleton enterprise beans
 Only @Dependent and @ApplicationScoped is allowed on singleton session beans.
 */
public class SingletonSLSB {

    @Inject
    private BookDao<Book> bookDao;

    public String requestSingletonSLSB() {
	final Book newbook = new Book();
	newbook.setBookName("bookName" + (Math.random() * 10));

	bookDao.save(newbook);

	System.out.println("These are persisted objects");
	for (final Book book : bookDao.findAll()) {
	    System.out.println(book.getBookName());
	}

	// dummyUsage.findSubscriberIdByName("requestWhatTheOtherGuyHad");
	return "requestSingletonSLSB";
    }
}