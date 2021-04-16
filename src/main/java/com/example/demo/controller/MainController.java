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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    BookServer bookServer;

    /**
     * 进入主界面
     *
     * @return 主界面 index.html
     */
    @RequestMapping("/")
    public String main_page(Model model) {
        List<Book> bookList = bookServer.findAllBooks();    // 将所有书放进来
        model.addAttribute("bookList", bookList);
        return "index";
    }

    /**
     * TODO 图书简介
     *
     * @return 图书简介页
     */
    @RequestMapping("/abstract")
    public String mAbstract(@RequestParam("title") String title, Model model) {
        Book book = bookServer.getBookByTitle(title);
        model.addAttribute("book", book);
        String user = (String) model.getAttribute("user");
        boolean isInCollection;
        if (user == null) {
            isInCollection = false;
        } else {
            isInCollection = bookServer.isCollect(user, title);
        }
        model.addAttribute("isInCollection", isInCollection);
        return "abstract";
    }

    /**
     * TODO 搜索功能
     *
     * @param title 书标题
     * @return 搜索结果
     */
    @RequestMapping("/title")
    public String search(@RequestParam("title") String title, Model model) {
        model.addAttribute("book", bookServer.getBookByTitle(title));
        return "index";
    }

    /**
     * 预览界面
     *
     * @param title 书名
     */
    @RequestMapping("/preview")
    public String preview(@RequestParam("title") String title, Model model) {
        model.addAttribute("path", bookServer.getBookByTitle(title));
        return "preview";
    }

    /**
     * 添加收藏
     * @param title
     * @param model
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/collection")
    public String addCollection(@RequestParam("title") String title, Model model, RedirectAttributes redirectAttributes) {
        bookServer.setCollection((String) model.getAttribute("user"), title);
        redirectAttributes.addAttribute("title", title);
        return "redirect:/abstract";
    }

    /**
     * 读取pdf文件
     *
     * @param filename 文件名
     * @param request 请求
     * @param response 响应
     */
    @RequestMapping(value = "/preview_file", method = RequestMethod.GET)
    public void pdfStreamHandler(@RequestParam("filename") String filename, HttpServletRequest request, HttpServletResponse response) {
        System.out.println(filename);
        File file = new File("./src/main/resources/static" + filename);
        if (file.exists()) {
            byte[] data = null;
            try {
                FileInputStream input = new FileInputStream(file);
                data = new byte[input.available()];
                input.read(data);
                response.getOutputStream().write(data);
                input.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 登出界面
     * @param model
     * @return
     */
    @RequestMapping("/logout")
    public String logout(Model model, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("select");
        request.getSession().removeAttribute("user");
        System.out.println(request.getSession().getAttribute("user"));
        return "redirect:/";
    }

}
