package com.example.demo.controller;

import com.example.demo.dao.CollectionInfo;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.BookServer;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    BookServer bookServer;

    /**
     * 登录
     *
     * @return 登录页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 注册
     *
     * @return 注册成功重定向
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("phone") String phone) {
        userService.registerUser(username, password, phone);
        return "redirect:/login";
    }

    /**
     * 成功登录跳转界面
     *
     * @return 成功跳转界面 login_success.html
     */
    @RequestMapping(path = "/login_success.do", method = RequestMethod.GET)
    public String login_page(Model model, HttpServletRequest request) {
        model.addAttribute("user", request.getSession().getAttribute("user"));
        return "login_success";
    }

    /**
     * 进入个人中心
     *
     * @return 个人空间界面 personal.html
     */
    @RequestMapping("/personal")
    public String personal_page(Model model, HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("user");
        List<CollectionInfo> collectionList = bookServer.getCollectionByUsername(username);
        model.addAttribute("collectionList", collectionList);
        UserInfo userInfo = (UserInfo) userService.loadUserByUsername(username);
        model.addAttribute("phone", userInfo.getPhone());
        return "personal";
    }

    /**
     * 修改手机号
     *
     * @param map 手机号
     * @return 重定向回主界面
     */
    @RequestMapping(value = "/changePhone", method = RequestMethod.POST)
    public String changePhone(@RequestParam Map<String, String> map, HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("user");
        userService.changePhone(username, map.get("phone"));
        return "redirect:/personal";
    }
}
