package com.example.demo.controller;

import com.example.demo.entity.UserInfo;
import com.example.demo.service.BookService;
import com.example.demo.service.UserService;
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
public class UserControllerTest {
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext ctx;

    @MockBean
    private UserService userService;

    @MockBean
    private BookService bookService;

    @Before
    public void before() {
        //使用 WebApplicationContext构建 MockMvc
        mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
        setUp();
    }

    public void setUp() {
        Mockito.when(bookService.getCollectionByUsername("admin"))
                .thenReturn(new ArrayList<>());
        Mockito.when(userService.registerUser("aaa", "bbb", "123"))
                .thenReturn(true);
        Mockito.when(userService.loadUserByUsername("admin")).thenReturn(
                new UserInfo("admin", "123", "145", "admin",
                        true, true, true, true));
    }

    @Test
    public void login() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/login"))
                .andExpect(status().isOk()) // 期待返回状态吗码200
                .andDo(print()); // 打印返回的 http response 信息
    }

    @Test
    public void register() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .post("/register").param("username", "aaa")
                .param("password", "bbb")
                .param("phone", "123"))
                .andExpect(status().is3xxRedirection()) // 期待返回状态吗码200
                .andDo(print()); // 打印返回的 http response 信息
    }

    @Test
    public void login_page() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/login_success.do").sessionAttr("user", "admin"))
                .andExpect(status().isOk()) // 期待返回状态吗码200
                .andDo(print()); // 打印返回的 http response 信息
    }

    @Test
    public void personal_page() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/personal").sessionAttr("user", "admin"))
                .andExpect(status().isOk()) // 期待返回状态吗码200
                .andDo(print()); // 打印返回的 http response 信息
    }

    @Test
    public void changePhone() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .post("/changePhone").param("phone", "789")
        .sessionAttr("user", "admin"))
                .andExpect(status().is3xxRedirection()) // 期待返回状态吗码200
                .andDo(print()); // 打印返回的 http response 信息
    }
}
