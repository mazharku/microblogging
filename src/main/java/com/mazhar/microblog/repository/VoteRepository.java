/**
 * 
 */
package com.mazhar.microblog.repository;

import com.mazhar.microblog.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

/**
 * @author mazhar
 *
 */
public interface VoteRepository extends JpaRepository<Vote, UUID>{
	
	@Query(value = "SELECT COUNT(*) FROM {h-schema}vote WHERE post_id =:post_id AND vote=true", nativeQuery = true)
	public long getVotesOfPost(@Param("post_id") UUID postId);
	
	@Query(value = "SELECT * FROM {h-schema}vote WHERE voter_id =:voter_id AND post_id=:post_id", nativeQuery = true)
	public Vote getVoteOfUser(@Param("post_id") UUID post,@Param("voter_id") UUID voter);

	@Query(value = "UPDATE {h-schema}vote  SET vote = :vote  WHERE voter_id = :voter_id AND post_id = :post_id", nativeQuery = true)
	public boolean updateVote(@Param("vote") boolean vote,@Param("voter_id") UUID voterId, @Param("post_id") UUID postId);


	@Query(value = "SELECT * FROM {h-schema}vote WHERE post_id =:post_id AND vote=true", nativeQuery = true)
	public List<Vote> getVotesByPost( @Param("post_id") UUID postId);

}
