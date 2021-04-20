/**
 * 
 */
package com.mazhar.microblog.webService;

import static com.mazhar.microblog.util.AppConstant.ROOT_PATH;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mazhar.microblog.model.BlogUser;
import com.mazhar.microblog.service.UserService;
import com.mazhar.microblog.util.AppResponse;

/**
 * @author mazhar
 *
 */
@RestController
@RequestMapping(path = ROOT_PATH + "votes", produces = { "application/json" })
public class BlogUserResource {
	private Logger log = LoggerFactory.getLogger(BlogPostResource.class);
	@Autowired
	private UserService service;
	
	@PostMapping("/")
	ResponseEntity<?> createUser(@RequestBody BlogUser user) {
		try {
			service.createUser(user);
			return new ResponseEntity<Object>(AppResponse.resourceCreated(), new HttpHeaders(), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Object>(AppResponse.operationFail(e.getMessage()), new HttpHeaders(),
					HttpStatus.OK);
		}
	}
}
