/**
 * 
 */
package com.mazhar.microblog.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mazhar.microblog.model.Vote;

/**
 * @author mazhar
 *
 */
public interface VoteRepository extends JpaRepository<Vote, UUID>{

}
