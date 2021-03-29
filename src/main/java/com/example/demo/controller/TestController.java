package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestController {

    //主界面
    @RequestMapping("/")
    public String mainpage() { return "home"; }

    //主界面
    @RequestMapping("/home")
    public String home() { return "home"; }

    //登录界面
    @RequestMapping("/login")
    public String userLogin() {
        return "demo_sign";
    }

    //失败界面，暂未用
    @RequestMapping("/login_error")
    public String loginError() {
        return "demo_error";
    }

    //成功跳转
    @RequestMapping("/login_success")
    public String loginSuccess(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        return "demo_success";
    }

    //测试界面，暂未用
    @RequestMapping("/whoim")
    public String whoim() {
        //return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "asdsadasd";
    }

    @RequestMapping("/demo2")
    public String demo2(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        return "demo2";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/user")
    public String user() {
        return "user";
    }
}
