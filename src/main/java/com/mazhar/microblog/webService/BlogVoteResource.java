/**
 * 
 */
package com.mazhar.microblog.webService;

import static com.mazhar.microblog.util.AppConstant.ROOT_PATH;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mazhar.microblog.service.VoteService;
import com.mazhar.microblog.util.AppResponse;

/**
 * @author mazhar
 *
 */
@RestController
@RequestMapping(path = ROOT_PATH + "votes", produces = { "application/json" })
public class BlogVoteResource {
	private Logger log = LoggerFactory.getLogger(BlogPostResource.class);
	private VoteService service;

	@Autowired
	public void setBlogPostService(VoteService service) {
		this.service = service;
	}

	@GetMapping("/{post_id}")
	ResponseEntity<?> getPosts(@PathVariable(name = "post_id") UUID postId) {
		return new ResponseEntity<Object>(service.totalNumberOfVoteOfPost(postId), new HttpHeaders(), HttpStatus.OK);
	}

	@PatchMapping("/{post_id}/{voter_id}")
	ResponseEntity<?> updateVote(@PathVariable(name = "post_id") UUID postId,
			@PathVariable(name = "voter_id") UUID voterId) {
		try {
			return new ResponseEntity<Object>(service.voteAPost(postId, voterId), new HttpHeaders(), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Object>(AppResponse.operationFail(e.getMessage()), new HttpHeaders(),
					HttpStatus.OK);
		}

	}
}
