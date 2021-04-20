/**
 * 
 */
package com.mazhar.microblog.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mazhar.microblog.exception.ResourceNotFound;
import com.mazhar.microblog.model.BlogPost;
import com.mazhar.microblog.model.dto.PostDTO;

/**
 * @author mazhar
 *
 */
@Service
public class BlogPostService implements MicroBlogGenericService<PostDTO, BlogPost>{

	@Override
	public List<PostDTO> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDTO getSingleItemById(UUID itemId) throws ResourceNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveEntity(BlogPost item) throws ResourceNotFound {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEntity(BlogPost item, UUID key) throws ResourceNotFound {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UUID itemId) throws ResourceNotFound {
		// TODO Auto-generated method stub
		return false;
	}

}
