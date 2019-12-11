package com.cis.inventory.book.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cis.inventory.book.model.Book;
import com.cis.inventory.book.model.User;

/**

* The is the JPA Repository for the Book Entity .
* We define the necessary methods which We will be implementing in the Book Service

* @version 1.0

* @author CIS

*/
@Repository
public interface BookRepository extends CrudRepository<Book, Long>  {

	public List<Book> findByTitle(String title);
	public List<Book> findByAuthor(User author);
	public List<Book> findByIsbn(String isbn);
	public List<Book> findByPublisher(User publisher);
	public List<Book> findByStock(Integer stock);
}
