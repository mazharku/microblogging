/**
 *
 */
package com.mazhar.microblog.service;

import com.mazhar.microblog.exception.ResourceNotFound;
import com.mazhar.microblog.model.BlogPost;
import com.mazhar.microblog.model.BlogUser;
import com.mazhar.microblog.model.Vote;
import com.mazhar.microblog.model.dto.VoteDTO;
import com.mazhar.microblog.repository.PostRepository;
import com.mazhar.microblog.repository.UserRespository;
import com.mazhar.microblog.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Stream;

/**
 * @author mazhar
 *
 */
@Service
public class VoteService {

    private UserRespository userRepository;
    private VoteRepository repository;
    private PostRepository postRepository;

    public VoteService(UserRespository userRepository, VoteRepository repository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.repository = repository;
        this.postRepository = postRepository;
    }

    public boolean isLikedByCurrentUser(UUID postId, UUID currentUser) {
        return repository.getVotesByPost(postId).stream().anyMatch(e -> e.getVoter().getId().equals(currentUser));
    }

    public int totalNumberOfVoteOfPost(UUID postId) {
        return (int) repository.getVotesOfPost(postId);
    }

    public boolean voteAPost(UUID postID, UUID voterID) throws ResourceNotFound {
        BlogUser user = userRepository.findById(voterID).orElseThrow(() -> new ResourceNotFound("No user found"));
        BlogPost post = postRepository.findById(postID).orElseThrow(() -> new ResourceNotFound("No post found"));
        Vote vote = repository.getVoteOfUser(postID, voterID);
        if (vote == null) {
            Vote v = new Vote();
            v.setPost(post);
            v.setVoter(user);
            v.setVote(true);
            repository.save(v);
        } else {
            vote.setVote(!vote.isVote());
            repository.save(vote);
        }

        return true;

    }

}
