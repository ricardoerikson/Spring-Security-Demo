package com.trit.security.controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.trit.security.Application;
import com.trit.security.controllers.consts.ws.WsUserApi;
import com.trit.security.controllers.response.EStatusDescription;
import com.trit.security.jpa.entity.User;
import com.trit.security.repository.IUserRepository;
import com.trit.security.utils.TestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private IUserRepository repository;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testPostCreateNewUser() throws JsonProcessingException, Exception {
        User user = new User("Jon", "Snow", "youknownothing");
        mockMvc.perform(MockMvcRequestBuilders.post(WsUserApi.USERS).contentType(MediaType.APPLICATION_JSON)
                .content(TestUtils.convertObjectToJsonBytes(user))).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(EStatusDescription.SUCCESS.getValue()));
        User one = repository.findOne(1L);
        Assert.assertEquals("Jon", one.getFirstName());
        Assert.assertFalse(one.getLastName().equals("Stark"));
    }

}
