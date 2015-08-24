package com.trit.security.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.trit.security.Application;
import com.trit.security.jpa.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    public void testAddUserToRespository() throws Exception {
        repository.save(new User("Frodo", "Bolseiro", "onering"));
        repository.save(new User("Tony", "Stark", "1r0nm4n"));
        repository.save(new User("Sansa", "Stark", "winteriscoming"));
        repository.save(new User("Arya", "Stark", "valarmorgulis"));

        System.out.println("Users found with findAll():");
        System.out.println();
        for (User user : repository.findAll()) {
            System.out.println(user);
        }

        System.out.println();
        User user = repository.findOne(1L);
        System.out.println("User found with findOne(1L)");
        System.out.println(user);

        Assert.assertEquals(user.getFirstName(), "Frodo");

    }

}
