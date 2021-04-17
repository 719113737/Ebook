package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    BookService bookService;

    /**
     * 进入主界面
     *
     * @return 主界面 index.html
     */
    @RequestMapping("/")
    public String main_page(Model model) {
        List<Book> bookList = bookService.findAllBooks();    // 将所有书放进来
        model.addAttribute("bookList", bookList);
        return "index";
    }

    /**
     * TODO 图书简介
     *
     * @return 图书简介页
     */
    @RequestMapping("/abstract")
    public String mAbstract(@RequestParam("title") String title, Model model, HttpServletRequest request) {
        Book book = bookService.getBookByTitle(title);
        model.addAttribute("book", book);
        String user = (String) request.getSession().getAttribute("user");
        boolean isInCollection;
        if (user == null) {
            isInCollection = false;
        } else {
            isInCollection = bookService.isCollect(user, title);
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
        model.addAttribute("book", bookService.getBookByTitle(title));
        return "index";
    }

    /**
     * 预览界面
     *
     * @param title 书名
     */
    @RequestMapping("/preview")
    public String preview(@RequestParam("title") String title, Model model) {
        model.addAttribute("path", bookService.getBookByTitle(title));
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
    public String addCollection(@RequestParam("title") String title, @RequestParam("op") String operation, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("user");
        if ("add".equals(operation)){
            bookService.setCollection(username, title);
            redirectAttributes.addAttribute("title", title);
        }else if("del".equals(operation)){
            bookService.deleteCollection(username, title);
            redirectAttributes.addAttribute("title", title);
        }
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
        request.getSession().removeAttribute("user");
        return "redirect:/";
    }

}
