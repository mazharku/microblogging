/**
 * 
 */
package com.mazhar.microblog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.mazhar.microblog.exception.ResourceNotFound;
import com.mazhar.microblog.model.BlogPost;
import com.mazhar.microblog.model.dto.PostDTO;
import com.mazhar.microblog.repository.PostRepository;

/**
 * @author mazhar
 *
 */
@Service
public class BlogPostService {
 
	private PostRepository repository;
	private ModelMapper modelMapper;
	
	public BlogPostService(PostRepository repository, ModelMapper modelMapper) {
		this.repository = repository;
		this.modelMapper = modelMapper;
	}
	
	public List<PostDTO> getAllItems() {
		List<PostDTO> posts = new ArrayList<>();
		repository.findAll().forEach(e -> {
			PostDTO dto = modelMapper.map(e, PostDTO.class);
			posts.add(dto);
		});
		return posts;
	}

	
	public PostDTO getPostById(UUID itemId) throws ResourceNotFound {
		return repository.findById(itemId).map(e -> modelMapper.map(e, PostDTO.class))
				.orElseThrow(() -> new ResourceNotFound("No Post found with this id"));
	}
 
	public List<PostDTO> getPostsByUser(UUID userId) throws ResourceNotFound {
		List<PostDTO> posts = new ArrayList<>();
		repository.getPostByUser(userId).forEach(e -> {
			PostDTO dto = modelMapper.map(e, PostDTO.class);
			posts.add(dto);
		});
		return posts;
	}
	
	public boolean createPost(BlogPost item) throws ResourceNotFound {
		repository.save(item);
		return true;
	}

	
	public boolean delete(UUID itemId) throws ResourceNotFound {
		repository.deleteById(itemId);
		return true;
	}

}
