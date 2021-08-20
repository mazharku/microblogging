/**
 * 
 */
package com.mazhar.microblog.webService;

import static com.mazhar.microblog.util.AppConstant.ROOT_PATH;

import java.util.UUID;

import com.mazhar.microblog.exception.ResourceNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mazhar.microblog.model.BlogPost;
import com.mazhar.microblog.model.dto.PostDTO;
import com.mazhar.microblog.service.BlogPostService;
import com.mazhar.microblog.util.AppResponse;

/**
 * @author mazhar
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path = ROOT_PATH + "posts", produces = { "application/json" })
public class BlogPostResource {
	private BlogPostService service;

	@Autowired
	public void setBlogPostService(BlogPostService service) {
		this.service = service;
	}

	@PostMapping("/")
	ResponseEntity<?> createPost(@RequestBody BlogPost post) throws ResourceNotFound {
			service.createPost(post);
			return new ResponseEntity<Object>(AppResponse.resourceCreated(), new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/")
	ResponseEntity<?> getPosts() {
		return new ResponseEntity<Object>(service.getAllItems(), new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	ResponseEntity<?> getPostById(@PathVariable(name = "id") UUID id) throws ResourceNotFound {
			PostDTO category = (PostDTO) service.getPostById(id);
			return new ResponseEntity<Object>(category, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/user/{userid}")
	ResponseEntity<?> getPostByUser(@PathVariable(name = "userid") UUID userid) throws ResourceNotFound {
			return new ResponseEntity<Object>(service.getPostsByUser(userid), new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<?> deletePost(@PathVariable(name = "id") UUID id) throws ResourceNotFound {
			service.delete(id);
			return new ResponseEntity<Object>(AppResponse.operationSuccess(), new HttpHeaders(), HttpStatus.OK);
	}

}
