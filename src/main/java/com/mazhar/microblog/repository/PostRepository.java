/**
 * 
 */
package com.mazhar.microblog.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mazhar.microblog.model.BlogPost;

/**
 * @author mazhar
 *
 */
public interface PostRepository  extends JpaRepository<BlogPost, UUID>{


	@Query(value = "SELECT * FROM {h-schema}blog_post WHERE blog_user_id =:userid", nativeQuery = true)
	public List<BlogPost> getPostByUser(@Param("userid") UUID userid);
}
