package xyz.sdju.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-07-28 14:45
 */
@Controller
public class PublishController {
    @GetMapping("/publish")
    public String publish(){
        return  "publish";
    }
}
