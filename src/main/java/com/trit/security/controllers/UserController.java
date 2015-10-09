package com.trit.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.trit.security.controllers.response.HttpResponseStatus;
import com.trit.security.controllers.response.SuccessStatus;
import com.trit.security.jpa.entity.User;
import com.trit.security.repository.IUserRepository;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private IUserRepository repository;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<HttpResponseStatus> actionSaveUser(@RequestBody User user) {
        repository.save(user);
        return new ResponseEntity<HttpResponseStatus>(new SuccessStatus(), HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> actionGetAllUsers() {
        return Lists.newArrayList(repository.findAll());
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public User actionGetUser(@PathVariable("userId") Long userId) {
        User user = repository.findOne(userId);
        return user;
    }

}
