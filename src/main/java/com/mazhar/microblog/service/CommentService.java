/**
 * 
 */
package com.mazhar.microblog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
	private ModelMapper modelMapper;

	public CommentService(CommentRepository repository, ModelMapper modelMapper) {
		this.repository = repository;
		this.modelMapper = modelMapper;
	}

	public boolean commentAPost(Comment comment) {
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
