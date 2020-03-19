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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import javax.servlet.http.Cookie;

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
       String result = mockMvc.perform(get("/book")
                .param("name","tom")
                .param("id", "1000")
                .param("page","1")
                .param("size","15")
                .param("sort","name,desc")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void whenCreateSuccess() throws Exception{
        String content = "{\"id\":\"1\",\"name\":\"战争于和平\",\"content\":\"好书\",\"publishDate\":\"2020-03-19\"}";
        String result = mockMvc.perform(post("/book").content(content)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void whenUpdateSuccess() throws Exception{
        String content = "{\"id\":null,\"name\":\"战争于和平\",\"content\":\"好书\",\"publishDate\":\"2020-03-19\"}";
        String result = mockMvc.perform(put("/book/1").content(content)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void whenCookieOrHeaderExists() throws Exception{
        mockMvc.perform(get("/book/1")
                .cookie(new Cookie("tooken","12345"))
                .header("auth","xxxxx")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void whenDeleteSuccess() throws Exception{
        mockMvc.perform(delete("/book/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
