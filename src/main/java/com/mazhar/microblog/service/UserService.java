/**
 * 
 */
package com.mazhar.microblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazhar.microblog.model.BlogUser;
import com.mazhar.microblog.repository.UserRespository;

/**
 * @author mazhar
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRespository repository;
	
	public boolean createUser(BlogUser user)  {
		repository.save(user);
		return true;
	}
}
