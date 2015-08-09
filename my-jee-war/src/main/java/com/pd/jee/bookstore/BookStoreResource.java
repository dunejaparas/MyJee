package com.pd.jee.bookstore;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

import com.pd.jee.api.BookServiceLocal;
import com.pd.jee.common.ResponseData;
import com.pd.jee.ejb.entity.generic.dao.Book;

@Path("/bookstore")
public class BookStoreResource {

    @Inject
    BookServiceLocal<Book> bookServiceLocal;

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON })
    public Response getAllBooksAtTheStore() {

	final Collection<Book> findAllBooks = bookServiceLocal.findAll();
	final ResponseData responseData = new ResponseData();
	responseData.setParameters(findAllBooks.toArray());
	responseData.setCode(Status.OK);
	return Response.status(responseData.getCode()).entity(responseData).build();
    }

    @POST
    @Path("/{bookName}")
    @Consumes({ MediaType.APPLICATION_JSON })
    public String createBookAtTheStore(@PathParam("bookName") final String bookName) {
	final Book newBook = new Book();
	newBook.setBookName(bookName);
	final boolean isSaved = bookServiceLocal.save(newBook);
	if (isSaved) {
	    return "{\"result\":\" Success " + newBook.toString() + " \"}";
	} else {
	    return "{\"result\":\" Failed " + newBook.toString() + "  \"}";
	}
    }

}
