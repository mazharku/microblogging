/**
 * 
 */
package com.mazhar.microblog.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazhar.microblog.exception.ResourceNotFound;
import com.mazhar.microblog.model.BlogPost;
import com.mazhar.microblog.model.Vote;
import com.mazhar.microblog.repository.PostRepository;
import com.mazhar.microblog.repository.VoteRepository;

/**
 * @author mazhar
 *
 */
@Service
public class VoteService {

	private VoteRepository repository;
	private PostRepository postRepository;
	

	public VoteService(VoteRepository repository, PostRepository postRepository) {
		this.repository = repository;
		this.postRepository = postRepository;
	}
	
	public int totalNumberOfVoteOfPost(UUID postId) {
		return (int) repository.getVotesOfPost(postId);
	}
	
	public boolean voteAPost(UUID postID, UUID voterID) throws ResourceNotFound {
		BlogPost post = postRepository.findById(postID).orElseThrow(()-> new ResourceNotFound("No post found"));
		Vote vote = repository.getVoteOfUser(voterID);
		return UpdateVote(postID,voterID, vote!=null);
		
	}
	
   private boolean  UpdateVote(UUID postID, UUID voterID, boolean isVoted) {
	   return repository.updateVote(isVoted, voterID, postID);
   }
}
