package com.cis.inventory.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cis.inventory.book.model.Book;
import com.cis.inventory.book.model.User;
import com.cis.inventory.book.repository.UserRepository;
import com.cis.inventory.book.serviceImpl.BookServiceImpl;
import com.cis.inventory.book.serviceImpl.UserServiceImpl;


/**

* The class is having the rest services for create,edit,delete the book model.

* @version 1.0

* @author CIS

*/
@RestController
@RequestMapping("/rest/book")
public class BookController {

	@Autowired
	BookServiceImpl bookService;

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private UserRepository userRepository ;
	
	/** 
	* The method is used for creating book object 
	* Takes a Book model object and output response
	* 201 for saved and 500 for error 
	* @version 1.0
	* @author CIS
	*/
	@PostMapping(path="/create",consumes = {MediaType.APPLICATION_JSON_VALUE})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String>  create(@RequestBody Book book) {
		System.out.println("book : "+book.toString()); 
		Boolean response = bookService.save(book) ;
		if(response==true) {
			return new ResponseEntity<String>(HttpStatus.CREATED) ;
		} else {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR) ;
		} 
	}

	/** 
	* The method is used for updating book object 
	* Takes a existing Book model object and output response
	* 201 for saved and 500 for error 
	* @version 1.0
	* @author CIS
	*/
	@PostMapping("/edit")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> update(@RequestBody Book book) {
		Boolean response = bookService.update(book) ;
		if(response==true) {
			return new ResponseEntity<String>(HttpStatus.CREATED) ;
		} else {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR) ;
		}
	}

	/** 
	* The method is used for fetching book object 
	* Takes id of the object and output corresponding object
	* if it exists or null if not present 
	* @version 1.0
	* @author CIS
	*/
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/get/{id}")
	public Book get(@PathVariable  Long id) {
		if(id!=null) {
			Book response = bookService.get(id) ;
			return response ;
		}
		return null ;
	}

	/** 
	* The method is used for deleting book object 
	* Takes a existing Book model object and output response
	* 201 for saved and 500 for error 
	* @version 1.0
	* @author CIS
	*/
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		if(id!=null) {
			Boolean response = bookService.delete(id) ;
			if(response==true) {
				return new ResponseEntity<String>(HttpStatus.OK) ;
			} 
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND) ;
	}

	
	/** 
	* The method is used for fetching all book object 
	* Takes a nothing and output list of books objects 
	* @version 1.0
	* @author CIS
	*/
	@GetMapping("/getall")
	public List<Book> getAll() {
		List<Book> books = bookService.getAll();
		return books;
	}
	
	/** 
	* The method is used for fetching all book object out of stock
	* Takes a nothing and output list of books objects having stock 0 
	* @version 1.0
	* @author CIS
	*/
	@GetMapping("/getoutofstockbooks")
	public List<Book> getAllOutOfBooks() {
		List<Book> books = bookService.getAllOutOfStock();
		return books;
	}
 
	/** 
	* The method is used for fetching all user objects
	* Takes a nothing and output list of user objects having role USER 
	* @version 1.0
	* @author CIS
	*/
	@GetMapping("/getallusers")
	public List<User> getAllUsers() {
		return userService.getAll();
	}
}
