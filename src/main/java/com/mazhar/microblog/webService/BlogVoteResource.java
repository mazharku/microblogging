/**
 *
 */
package com.mazhar.microblog.webService;

import static com.mazhar.microblog.util.AppConstant.ROOT_PATH;

import java.util.UUID;

import com.mazhar.microblog.exception.ResourceNotFound;
import com.mazhar.microblog.model.dto.VoteDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mazhar.microblog.service.VoteService;
import com.mazhar.microblog.util.AppResponse;

/**
 * @author mazhar
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path = ROOT_PATH + "votes", produces = {"application/json"})
public class BlogVoteResource {

    private VoteService service;

    @Autowired
    public void setBlogPostService(VoteService service) {
        this.service = service;
    }

    @PostMapping("/{post_id}")
    ResponseEntity<?> isLikedByCurrentUser(@PathVariable(name = "post_id") UUID postId, @RequestParam(name = "user", required = false) UUID currentUser) {
        boolean vote = service.isLikedByCurrentUser(postId, currentUser);
        return new ResponseEntity<Object>(vote, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{post_id}")
    ResponseEntity<?> getVoteCounts(@PathVariable(name = "post_id") UUID postId) {
        int vote = service.totalNumberOfVoteOfPost(postId);
        return new ResponseEntity<Object>(vote, new HttpHeaders(), HttpStatus.OK);

    }

    @PutMapping("/{post_id}")
    ResponseEntity<?> updateVote(@PathVariable(name = "post_id") UUID postId,
                                 @RequestParam(name = "user") UUID voterId) throws ResourceNotFound {
        return new ResponseEntity<Object>(service.voteAPost(postId, voterId), new HttpHeaders(), HttpStatus.OK);


    }
}
