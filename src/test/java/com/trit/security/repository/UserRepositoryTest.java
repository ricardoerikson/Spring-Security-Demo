package com.trit.security.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.trit.security.Application;
import com.trit.security.jpa.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Before
    public void setUp() {
        System.out.println("Persisting new users:");
        repository.save(new User("Frodo", "Bolseiro", "onering"));
        repository.save(new User("Tony", "Stark", "1r0nm4n"));
        repository.save(new User("Sansa", "Stark", "winteriscoming"));
        repository.save(new User("Arya", "Stark", "valarmorgulis"));
        System.out.println("Users found with findAll():");
        System.out.println();
        for (User user : repository.findAll()) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindFirstAddedUser() throws Exception {
        User user = repository.findOne(1L);
        System.out.println("User found with findOne(1L)");
        System.out.println(user);
        Assert.assertEquals(user.getFirstName(), "Frodo");
    }

    @Test
    public void testEntitiesCount() throws Exception {
        long count = repository.count();
        Assert.assertEquals(4, count);
    }

    @Test
    public void testFindUserByLastName() throws Exception {
        List<User> foundByLastName = repository.findByLastName("Stark");
        Assert.assertEquals(3, foundByLastName.size());
        Assert.assertEquals("Stark", foundByLastName.get(0).getLastName());
    }

}
