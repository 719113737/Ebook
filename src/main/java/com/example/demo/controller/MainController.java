package com.example.demo.controller;

import com.example.demo.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    /**
     * 进入主界面
     * @return 主界面 index.html
     */
    @RequestMapping("/")
    public String main_page(Model model) {
        List<Book> bookList = new ArrayList<>();
        for (int i=0;i<3;i++){
            Book book = new Book();
            book.title = "算法导论";
            book.mAbstract = "《算法导论》自第一版出版以来，已经成为世界范围内广泛使用的大学教材和专业人员的标准参考手册。本书全面论述了算法的内容，从一定深度上涵盖了算法的诸多方面，同时其讲授和分析方法又兼顾了各个层次读者的接受能力...";
            book.imagePath = "/img/book1.jpg";
            book.category = "IT/算法";
            book.filePath = "";
            book.phases = "";
            bookList.add(book);
        }
        model.addAttribute("bookList", bookList);
        return "index";
    }

    /**
     * 图书简介
     * @return 图书简介页
     */
    @RequestMapping("/abstract")
    public String mAbstract(@RequestParam("title") String title, Model model){
        System.out.println(title);
        Book book = new Book();
        book.title = "算法导论";
        book.author = "张三";
        book.mAbstract = "《算法导论》自第一版出版以来，已经成为世界范围内广泛使用的大学教材和专业人员的标准参考手册。本书全面论述了算法的内容，从一定深度上涵盖了算法的诸多方面，同时其讲授和分析方法又兼顾了各个层次读者的接受能力...";
        book.imagePath = "/img/book1.jpg";
        book.category = "IT/算法";
        book.filePath = "";
        book.phases = "";
        model.addAttribute("book", book);
        return "abstract";
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
    public String preview(@RequestParam("title") String book) {
        return "preview";
    }

    /**
     * 添加收藏
     * @param title
     * @param model
     * @return
     */
    @RequestMapping("/collection")
    public String addCollection(@RequestParam("title") String title, Model model) {
        System.out.println(title);
        Book book = new Book();
        book.title = "算法导论";
        book.author = "张三";
        book.mAbstract = "《算法导论》自第一版出版以来，已经成为世界范围内广泛使用的大学教材和专业人员的标准参考手册。本书全面论述了算法的内容，从一定深度上涵盖了算法的诸多方面，同时其讲授和分析方法又兼顾了各个层次读者的接受能力...";
        book.imagePath = "/img/book1.jpg";
        book.category = "IT/算法";
        book.filePath = "";
        book.phases = "";
        model.addAttribute("book", book);
        return "abstract";
    }

    /**
     * 登录
     * @return 登录页面
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
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
    public String personal_page() {
        return "personal";
    }



}
