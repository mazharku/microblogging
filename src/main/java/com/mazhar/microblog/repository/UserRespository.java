/**
 * 
 */
package com.mazhar.microblog.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.mazhar.microblog.model.BlogUser;

/**
 * @author mazhar
 *
 */
public interface UserRespository extends CrudRepository<BlogUser, UUID>{

}
