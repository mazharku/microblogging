/**
 *
 */
package com.mazhar.microblog.webService;

import static com.mazhar.microblog.util.AppConstant.ROOT_PATH;

import com.mazhar.microblog.model.LoginRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mazhar.microblog.model.BlogUser;
import com.mazhar.microblog.service.UserService;
import com.mazhar.microblog.util.AppResponse;

import java.util.UUID;

/**
 * @author mazhar
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path = ROOT_PATH + "users", produces = {"application/json"})
public class BlogUserResource {

    private UserService service;

    public BlogUserResource(UserService service) {
        this.service = service;
    }

    @PostMapping("/registration")
    ResponseEntity<?> createUser(@RequestBody BlogUser user) throws Exception {
        service.createUser(user);
        return new ResponseEntity<Object>(AppResponse.resourceCreated(), new HttpHeaders(), HttpStatus.OK);

    }

    @PostMapping("/login")
    ResponseEntity<?> doLogIn(@RequestBody LoginRequest request) throws Exception {
        BlogUser user = service.dologIn(request);
        return new ResponseEntity<Object>(user, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/logout")
    ResponseEntity<?> doLogout(@RequestParam(name = "user") UUID userId) throws Exception {
        service.dologout(userId);
        return new ResponseEntity<Object>(true, new HttpHeaders(), HttpStatus.OK);
    }
}
