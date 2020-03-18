package com.example.bookshop_admin.controller;

import com.example.bookshop_admin.BookshopAdminApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.OutputStream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookshopAdminApplication.class)
public class BaseTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void whenQuerySuccess() throws Exception {
       String result = mockMvc.perform(MockMvcRequestBuilders.get("/book")
                .param("name","tom")
                .param("id", "1000")
                .param("page","1")
                .param("size","15")
                .param("sort","name,desc")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString();


    }

    @Test
    public void whenGetInfoSuccess() throws Exception {
       String result = mockMvc.perform(MockMvcRequestBuilders.get("/book/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("菊花侠大战桃花怪"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }
}
