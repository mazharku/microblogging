/**
 * 
 */
package com.mazhar.microblog.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mazhar.microblog.model.Comment;

/**
 * @author mazhar
 *
 */
public interface CommentRepository extends JpaRepository<Comment, UUID>{

}
