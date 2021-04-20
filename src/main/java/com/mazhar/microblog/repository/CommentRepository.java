/**
 * 
 */
package com.mazhar.microblog.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mazhar.microblog.model.Comment;

/**
 * @author mazhar
 *
 */
public interface CommentRepository extends JpaRepository<Comment, UUID>{


	@Query(value = "SELECT * FROM {h-schema}comment WHERE post_id =:post_id", nativeQuery = true)
	public List<Comment> getCommentsByPost(@Param("post_id") UUID postId);
}
