/**
 * 
 */
package com.mazhar.microblog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.mazhar.microblog.exception.ResourceNotFound;
import com.mazhar.microblog.model.BlogPost;
import com.mazhar.microblog.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.mazhar.microblog.model.Comment;
import com.mazhar.microblog.model.dto.CommentDTO;
import com.mazhar.microblog.repository.CommentRepository;

/**
 * @author mazhar
 *
 */
@Service
public class CommentService {

	private CommentRepository repository;
	private PostRepository postRepository;
	private ModelMapper modelMapper;

	public CommentService(CommentRepository repository,PostRepository postRepository, ModelMapper modelMapper) {
		this.repository = repository;
		this.postRepository = postRepository;
		this.modelMapper = modelMapper;
	}

	public boolean commentAPost(Comment comment, UUID postId) throws ResourceNotFound {
		BlogPost post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFound("No post found!"));
		comment.setPost(post);
		repository.save(comment);
		return true;
	}

	public List<CommentDTO> getAllComments(UUID postId) {
		List<CommentDTO> comments = new ArrayList<>();
		repository.getCommentsByPost(postId).forEach(e -> {
			CommentDTO dto = modelMapper.map(e, CommentDTO.class);
			comments.add(dto);
		});
		return comments;
	}

}
