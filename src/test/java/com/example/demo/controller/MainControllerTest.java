package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainControllerTest {

    private MockMvc mvc;
    @Autowired
    private WebApplicationContext ctx;

    @MockBean
    private BookService bookService;

    @Before
    public void before() {
        //使用 WebApplicationContext构建 MockMvc
        mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
        setUp();
    }

    public void setUp() {
        Mockito.when(bookService.findAllBooks())
                .thenReturn(new ArrayList<>());
        Mockito.when(bookService.getBookByTitle("算法导论"))
                .thenReturn(new Book("算法导论", "abc", "/img/algorithm.jpg", "sdf", "/pdf/algorithm.pdf", "asd", "qwe"));
    }

    @Test
    public void main_page() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/"))
                .andExpect(status().isOk()) // 期待返回状态吗码200
                .andDo(print()); // 打印返回的 http response 信息
    }

    @Test
    public void mAbstract() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/abstract").queryParam("title", "算法导论"))
                .andExpect(status().isOk()) // 期待返回状态吗码200
                .andDo(print()); // 打印返回的 http response 信息
    }

    @Test
    public void preview() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/preview").queryParam("title", "算法导论"))
                .andExpect(status().isOk()) // 期待返回状态吗码200
                .andDo(print()); // 打印返回的 http response 信息
    }

    @Test
    public void addCollection() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/collection").queryParam("title", "算法导论")
                .queryParam("op", "add").sessionAttr("user", "admin"))
                .andExpect(status().is3xxRedirection()) // 期待返回状态吗码302
                .andDo(print()); // 打印返回的 http response 信息
    }
}
