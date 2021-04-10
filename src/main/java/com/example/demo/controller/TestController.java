package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    //主界面
    @RequestMapping("/")
    public String index(Model model) {
        List<Book> bookList = new ArrayList<>();
        for (int i=0;i<3;i++){
            Book book = new Book();
            book.id = "1";
            book.title = "算法导论";
            book.mAbstract = "《算法导论》自第一版出版以来，已经成为世界范围内广泛使用的大学教材和专业人员的标准参考手册。本书全面论述了算法的内容，从一定深度上涵盖了算法的诸多方面，同时其讲授和分析方法又兼顾了各个层次读者的接受能力...";
            book.imagePath = "/img/book1.jpg";
            book.category = "IT/算法";
            book.filePath = "";
            book.publishDate = "";
            book.phases = "";
            bookList.add(book);
        }
        model.addAttribute("bookList", bookList);
        return "index";
    }

    //主界面
    @RequestMapping("/home")
    public String home(Model model) {
        List<Book> bookList = new ArrayList<>();
        for (int i=0;i<3;i++){
            Book book = new Book();
            book.id = "1";
            book.title = "算法导论";
            book.mAbstract = "《算法导论》自第一版出版以来，已经成为世界范围内广泛使用的大学教材和专业人员的标准参考手册。本书全面论述了算法的内容，从一定深度上涵盖了算法的诸多方面，同时其讲授和分析方法又兼顾了各个层次读者的接受能力...";
            book.imagePath = "/img/book1.jpg";
            book.category = "IT/算法";
            book.filePath = "";
            book.publishDate = "";
            book.phases = "";
            bookList.add(book);
        }
        model.addAttribute("bookList", bookList);
        return "index";
    }

    //登录界面
    @RequestMapping("/login")
    public String userLogin() {
        return "login";
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
    @RequestMapping("/abstract")
    public String mAbstract(){
        return "abstract";
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
