/**
 * 
 */
package com.mazhar.microblog.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mazhar.microblog.model.Vote;

/**
 * @author mazhar
 *
 */
public interface VoteRepository extends JpaRepository<Vote, UUID>{
	
	@Query(value = "SELECT COUNT(vote_id) FROM vote WHERE post_id =:post_id", nativeQuery = true)
	public long getVotesOfPost(@Param("post_id") UUID postId);
	
	@Query(value = "SELECT * FROM vote WHERE voter_id =:voter_id", nativeQuery = true)
	public Vote getVoteOfUser(@Param("voter_id") UUID voter);

	@Query(value = "UPDATE vote  SET vote = :vote  WHERE voter_id = :voter_id AND post_id = :post_id", nativeQuery = true)
	public boolean updateVote(@Param("vote") boolean vote,@Param("voter_id") UUID voterId, @Param("post_id") UUID postId);
	
}
