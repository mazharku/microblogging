/**
 * 
 */
package com.mazhar.microblog.repository;

import com.mazhar.microblog.model.BlogUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

/**
 * @author mazhar
 *
 */
public interface UserRespository extends CrudRepository<BlogUser, UUID>{
    @Query(value = "SELECT * FROM {h-schema}blog_user WHERE email=:email", nativeQuery = true)
    public Optional<BlogUser> getUserByMail(@Param("email") String email);
}
