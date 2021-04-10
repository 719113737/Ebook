package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    /**
     * 进入主界面
     * @return 主界面 index.html
     */
    @RequestMapping("/")
    public String main_page() {
        return "index";
    }

    /**
     * 搜索功能
     * @param title 书标题
     * @return 搜索结果
     */
    @RequestMapping("/title")
    public String search(@RequestParam("title")String title) {
        return "uncompleted";
    }

    /**
     * 预览书
     * @param book 书名
     */
    @RequestMapping("/preview")
    public String preview(@RequestParam("book") String book) {
        return "uncompleted";
    }

    /**
     * 成功登录跳转界面
     * @return 成功跳转界面 login_success.html
     */
    @RequestMapping(path = "/login_success",method = RequestMethod.GET)
    public String login_page() {
        return "login_success";
    }

    /**
     * 进入个人中心
     * @return 个人空间界面 personal.html
     */
    @RequestMapping("/personal")
    public String peronal_page() {
        return "personal";
    }



}
