package com.cis.inventory.book.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cis.inventory.book.model.Book;
import com.cis.inventory.book.repository.BookRepository;
import com.cis.inventory.book.service.BookService;

/**
 * 
 * The is the Book Service implementation , Where We defined the methods which
 * are declared in the book service
 * 
 * @version 1.0
 * 
 * @author CIS
 * 
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	/**
	 * The method is used for saving the user Entity
	 * takes Book type Object and returns Boolean true if saved else false
	 * 
	 * @version 1.0
	 * @author CIS
	 */
	@Override
	public Boolean save(Book book) {

		try {
			bookRepository.save(book);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * The method is used for fetching the user Entity
	 * takes book id and returns Book object for it
	 * 
	 * @version 1.0
	 * @author CIS
	 */
	@Override
	public Book get(Long book_id) {
		try {
			Optional<Book> book = bookRepository.findById(book_id);
			return book.get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * The method is used for updating the user Entity
	 * takes Book type Object and returns Boolean true if updated else false
	 * 
	 * @version 1.0
	 * @author CIS
	 */
	@Override
	public Boolean update(Book book) {
		try {
			Optional<Book> bookObject = bookRepository.findById(book.getId());
			if (bookObject != null) {
				bookRepository.save(book);
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * The method is used for deleting the book Entity
	 * takes book id and delete Book object for it
	 * 
	 * @version 1.0
	 * @author CIS
	 */
	@Override
	public Boolean delete(Long book_id) {
		try {
			Optional<Book> bookObject = bookRepository.findById(book_id);
			if (bookObject != null) {
				bookRepository.deleteById(book_id);
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * The method is used for fetching books objects
	 * takes nothing and returns all book objects 
	 * @version 1.0
	 * @author CIS
	 */
	@Override
	public List<Book> getAll() {
		try {
			List<Book> bookObject = (List<Book>) bookRepository.findAll();
			return bookObject;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * The method is used for fetching books objects having stock 0
	 * takes nothing and returns all book objects having stock 0
	 * @version 1.0
	 * @author CIS
	 */
	@Override
	public List<Book> getAllOutOfStock() {
		try {
			List<Book> bookObject = (List<Book>) bookRepository.findByStock(0);
			return bookObject;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
