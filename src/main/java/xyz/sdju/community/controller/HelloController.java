package xyz.sdju.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-07-24 09:24
 */
@Controller
public class HelloController {
    @GetMapping("/")
   public String index(){
        return "index";
    }
}
