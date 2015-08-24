package com.trit.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trit.security.controllers.response.HttpResponseStatus;
import com.trit.security.controllers.response.SuccessStatus;
import com.trit.security.jpa.entity.User;
import com.trit.security.repository.IUserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserRepository repository;

    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpResponseStatus> actionSaveUser(@RequestBody User user) {
        repository.save(user);
        return new ResponseEntity<HttpResponseStatus>(new SuccessStatus(), HttpStatus.OK);
    }

}
