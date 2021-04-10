package com.example.demo.controller;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.omg.CORBA.Request;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class BuyController {

    /**
     * 进入订单页
     * @return 订单页面 order.html
     */
    @RequestMapping("/order")
    public String order_page() {
        return "order";
    }

    /**
     * 添加订单
     * @param map
     * @return 成功：{"message":"0"} 不成功：{"message":"1"}
     */
    @RequestMapping("/order/add")
    public JSONObject add_order(@RequestBody Map<String,String> map) {
        //未完成
        return new JSONObject();
    }

    /**
     * 删除订单
     * @param map
     * @return 成功：{"message":"0"} 不成功：{"message":"1"}
     */
    @RequestMapping("/order/del")
    public JSONObject del_order(@RequestBody Map<String,String> map) {
        //未完成
        return new JSONObject();
    }

}
