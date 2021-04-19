/**
 * 
 */
package com.mazhar.microblog.service;

import java.util.List;
import java.util.UUID;

import com.mazhar.microblog.exception.ResourceNotFound;

/**
 * @author Mazhar Ibna Zahur
 *
 * Mar 24, 2021 11:27:46 PM
 * T is for DTO
 * S is for Actual Object
 */
public interface MicroBlogGenericService<T, S> {

	public List<T> getAllItems();
	
	public T getSingleItemById(UUID itemId) throws ResourceNotFound;
	
	public boolean saveEntity(S item) throws ResourceNotFound;
	
	public boolean updateEntity(S item, UUID key) throws ResourceNotFound;
	
	public boolean delete(UUID itemId) throws ResourceNotFound;
	
}
