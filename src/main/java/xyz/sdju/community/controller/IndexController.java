package xyz.sdju.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.sdju.community.Service.QuestionService;
import xyz.sdju.community.dto.PaginationDTO;

import javax.annotation.Resource;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-07-24 09:24
 */
@Controller
public class IndexController {
    @Resource
    private QuestionService questionService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page",defaultValue = "1")Integer page,
                        @RequestParam(name = "size",defaultValue = "5")Integer size) {
        PaginationDTO pagination = questionService.list(page,size);
        model.addAttribute("pagination",pagination);
        return "index";
    }
}
