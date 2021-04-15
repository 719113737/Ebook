package com.example.demo.controller;

import com.example.demo.service.BookServer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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
    private BookServer bookServer;

    @Before
    public void before() {
        //使用 WebApplicationContext构建 MockMvc
        mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    public void setUp() {
        // 数据打桩，设置该方法返回的 body一直是空的
        Mockito.when(bookServer.findAllBooks())
                .thenReturn(new ArrayList<>());
    }

    @Test
    public void main_page() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/"))
                .andExpect(status().isOk()) // 期待返回状态吗码200
                // JsonPath expression  https://github.com/jayway/JsonPath
                //.andExpect(jsonPath("$[1].name").exists()) // 这里是期待返回值是数组，并且第二个值的 name 存在，所以这里测试是失败的
                .andDo(print()); // 打印返回的 http response 信息
    }
}
