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
import org.springframework.web.bind.annotation.*;

import com.mazhar.microblog.model.Comment;
import com.mazhar.microblog.service.CommentService;
import com.mazhar.microblog.util.AppResponse;

/**
 * @author mazhar
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path = ROOT_PATH + "comments", produces = { "application/json" })
public class BlogCommentResource {
	private Logger log = LoggerFactory.getLogger(BlogPostResource.class);
	private CommentService service;

	@Autowired
	public void setCommentService(CommentService service) {
		this.service = service;
	}
	
	@GetMapping("/{post}")
	ResponseEntity<?> getCommentsOfPost(@PathVariable(name = "post") UUID postId) {
		return new ResponseEntity<Object>(service.getAllComments(postId), new HttpHeaders(), HttpStatus.OK);
	}
	 
	@PostMapping("/{post}")
	ResponseEntity<?> makeAComment(@PathVariable(name = "post") UUID postId, @RequestBody Comment comment) {
		try {
			service.commentAPost(comment, postId);
			return new ResponseEntity<Object>(AppResponse.resourceCreated(), new HttpHeaders(), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Object>(AppResponse.operationFail(e.getMessage()), new HttpHeaders(),
					HttpStatus.OK);
		}
	}
}
