/**
 * 
 */
package com.mazhar.microblog.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mazhar.microblog.model.BlogPost;

/**
 * @author mazhar
 *
 */
public interface PostRepository  extends JpaRepository<BlogPost, UUID>{

}
