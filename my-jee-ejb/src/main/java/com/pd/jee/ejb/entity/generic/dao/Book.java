package com.pd.jee.ejb.entity.generic.dao;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="books")
@SuppressWarnings("serial")
public class Book implements Serializable {

    // "CREATE TABLE books ( id integer PRIMARY KEY, name varchar(50))";
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long   bookId;

    @Column(name = "name")
    private String bookName;

    public long getBookId() {
	return bookId;
    }

    public void setBookId(final long bookId) {
	this.bookId = bookId;
    }

    public String getBookName() {
	return bookName;
    }

    public void setBookName(final String bookName) {
	this.bookName = bookName;
    }

    @Override
    public String toString() {
	return "[" + bookId + " " + bookName + "]";
    }

}