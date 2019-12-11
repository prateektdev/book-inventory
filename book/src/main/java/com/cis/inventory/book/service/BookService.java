package com.cis.inventory.book.service;

import java.util.List;

import com.cis.inventory.book.model.Book;

/**

* The is the Book Service interface ,
* Where We declare the methods which We will be calling in the Book Controller.
* The implementation of this interface is in bookServiceImpl

* @version 1.0

* @author CIS

*/
public interface BookService {

	public Boolean save(Book book);

	public Book get(Long book_id);

	public Boolean update(Book book);

	public Boolean delete(Long book_id);

	public List<Book> getAll();
	
	public List<Book> getAllOutOfStock();
}
