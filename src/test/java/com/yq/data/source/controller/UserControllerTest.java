package com.yq.data.source.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @auther: zpd
 * @Date: 2019/2/12 0012 13:43
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void whenQueryDB1AllSuccess() throws Exception {
        mockMvc.perform(get("/db1/user")
            .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].name").value("uuz"));
    }


    @Test
    public void whenQueryDB2AllSuccess() throws Exception {
        mockMvc.perform(get("/db2/user")
            .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].name").value("byz"));
    }

    @Test
    public void whenQueryDB1AllSuccessResult() throws Exception {
        String result = mockMvc.perform(get("/db1/user")
            .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();
        logger.info("result : {}",result);
    }
}
