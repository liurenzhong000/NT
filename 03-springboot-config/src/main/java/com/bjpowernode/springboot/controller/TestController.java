package com.bjpowernode.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:TestController
 * Package:com.bjpowernode.springboot.controller
 * Description:
 *
 * @date:2018/10/8 10:34
 * @author:bjpowernode.com
 */
@Controller
public class TestController {
    @RequestMapping("/boot/test")
    public @ResponseBody String test(Model model){
        return "这是Test请求";
    }
}
