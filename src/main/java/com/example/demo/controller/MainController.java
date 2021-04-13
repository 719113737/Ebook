package com.example.demo.controller;

import com.example.demo.dao.CollectionInfo;
import com.example.demo.entity.Book;
import com.example.demo.entity.Collection;
import com.example.demo.service.BookServer;
import com.example.demo.service.UserService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    BookServer bookServer;

    @Autowired
    UserService userService;

    /**
     * 进入主界面
     * @return 主界面 index.html
     */
    @RequestMapping("/")
    public String main_page(Model model) {
        List<Book> bookList = bookServer.findAllBooks();    // 将所有书放进来
        model.addAttribute("bookList", bookList);
        return "index";
    }

    /**
     * 图书简介
     * @return 图书简介页
     */
    @RequestMapping("/abstract")
    public String mAbstract(@RequestParam("title") String title, Model model){
        Book book = bookServer.getBookByTitle(title);
        model.addAttribute("book", book);
        boolean isInCollection = bookServer.isCollect((String)model.getAttribute("user"),title);
        model.addAttribute("isInCollection", isInCollection);
        return "abstract";
    }

    /**
     * 搜索功能
     * @param title 书标题
     * @return 搜索结果
     */
    @RequestMapping("/title")
    public String search(@RequestParam("title")String title,Model model) {
        model.addAttribute("book",bookServer.getBookByTitle(title));
        return "index";
    }

    /**
     * 预览书
     * @param title 书名
     */
    @RequestMapping("/preview")
    public String preview(@RequestParam("title") String title,Model model) {
        model.addAttribute("path",bookServer.getBookByTitle(title));
        return "preview";
    }

    /**
     * ------------------------------也先放着-------------------------
     * 添加收藏
     */
    @RequestMapping("/collection")
    public String addCollection(@RequestParam("title") String title, Model model, RedirectAttributes redirectAttributes) {
        bookServer.setCollection((String) model.getAttribute("user"),title);
        redirectAttributes.addAttribute("title", title);
        return "redirect:/abstract";
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
    public String login_page(Model model,HttpServletRequest request) {
        model.addAttribute("user", request.getSession().getAttribute("user"));
        return "login_success";
    }

    /**
     * 进入个人中心
     * @return 个人空间界面 personal.html
     */
    @RequestMapping("/personal")
    public String personal_page(Model model) {

        String username = (String) model.getAttribute("user");
        List<CollectionInfo> collectionList = bookServer.getCollectionByUsername(username);
        model.addAttribute("collectionList", collectionList);
        return "personal";
    }

    /**
     * 没有这种东西
     * @param model
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public String changePassword(Model model, RedirectAttributes redirectAttributes) {

        return "redirect:/personal";
    }


    /**
     * @param model
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/changePhone", method = RequestMethod.POST)
    public String changePhone(@RequestBody Map<String, String> map,Model model, RedirectAttributes redirectAttributes) {
        userService.changePhone(map.get("user"),map.get("phone"));
        return "redirect:/personal";
    }
}
