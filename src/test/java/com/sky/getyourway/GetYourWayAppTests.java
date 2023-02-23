package com.sky.getyourway;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
//@AutoConfigureMockMvc
public class GetYourWayAppTests {

    @Autowired
    private MockMvc mockMvc;
    @Test
//    @Ignore
    public void testAuthentication() throws Exception {
        // Testing authentication with correct credentials
        this.mockMvc.perform(post("/login")
                        .content("{\"username\":\"admin\", \"password\":\"adminpass\"}")).
                andDo(print()).andExpect(status().isOk());

        // Testing authentication with wrong credentials
        this.mockMvc.perform(post("/login")
                        .content("{\"username\":\"admin\", \"password\":\"wrongpwd\"}")).
                andDo(print()).andExpect(status().is4xxClientError());

    }



}
