package com.example.demo.controller;

import com.example.demo.dao.CollectionInfo;
import com.example.demo.service.BookServer;
import com.example.demo.service.UserService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
     * 成功登录跳转界面
     *
     * @return 成功跳转界面 login_success.html
     */
    @RequestMapping(path = "/login_success", method = RequestMethod.GET)
    public String login_page(Model model, HttpServletRequest request) {
        model.addAttribute("user", request.getSession().getAttribute("user"));
        return "login_success";
    }

    /**
     * TODO 进入个人中心
     *
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
     * TODO 修改手机号
     * @param model
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/changePhone", method = RequestMethod.POST)
    public String changePhone(@RequestBody Map<String, String> map, Model model, RedirectAttributes redirectAttributes) {
        userService.changePhone(map.get("user"), map.get("phone"));
        return "redirect:/personal";
    }
}
