package com.cis.inventory.book.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;

/**

* The class is the model for User Entity of the inventory.
* It have fields like title ,author ,ISBN ,publisher ,category,stock
* Author and Publisher are of user type ,
* category  is coming from the Enumeration bookCategory
* and stock is the quantity of books in sto\ck

* @version 1.0

* @author CIS

*/
@Entity 
public class Book {
	
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String title ;
	 
	@ManyToOne
	private User author ;
	
	@Column
	private String isbn ;
	 
	@ManyToOne
	private User publisher ;
 
	@Column
	private BookCategory category ;
	
	@Column
	private Integer stock ;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	 

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public User getPublisher() {
		return publisher;
	}

	public void setPublisher(User publisher) {
		this.publisher = publisher;
	}

	public BookCategory getCategory() {
		return category;
	}

	public void setCategory(BookCategory category) {
		this.category = category;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
 

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", publisher="
				+ publisher + ", category=" + category + ", stock=" + stock + "]";
	}

}
