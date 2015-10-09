package com.trit.security.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.trit.security.jpa.entity.User;

public interface IUserRepository extends CrudRepository<User, Long> {

    List<User> findByLastName(String lastName);

}
