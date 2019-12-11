package com.cis.inventory.book.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cis.inventory.book.model.User;

/**

* The is the JPA Repository for the User Entity .
* We define the necessary methods which We will be implementing in the User Service

* @version 1.0

* @author CIS

*/
@Repository
public interface UserRepository  extends CrudRepository<User, Long>{

	public User findByUsername(String username) ; 
}
