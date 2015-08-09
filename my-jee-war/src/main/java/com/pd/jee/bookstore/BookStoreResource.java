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

    // http://localhost:8080/my-jee/rest/bookstore/all
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

    // http://localhost:8080/my-jee/rest/bookstore/Harry Porter
    // http://localhost:8080/my-jee/rest/bookstore/Hello
    @POST
    @Path("/{bookName}")
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response createBookAtTheStore(@PathParam("bookName") final String bookName) {
	final Book newBook = new Book();
	newBook.setBookName(bookName);
	final boolean isSaved = bookServiceLocal.save(newBook);
	if (isSaved) {
	    return Response.status(Status.ACCEPTED).entity("{\"result\":\" Success " + newBook.toString() + " \"}").build();
	} else {
	    return Response.status(Status.ACCEPTED).entity("{\"result\":\" Failed " + newBook.toString() + " \"}").build();
	}
    }
}
