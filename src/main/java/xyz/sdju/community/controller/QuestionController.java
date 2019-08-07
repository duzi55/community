package xyz.sdju.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import xyz.sdju.community.service.QuestionService;
import xyz.sdju.community.dto.QuestionDTO;

import javax.annotation.Resource;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-08-07 08:54
 */
@Controller
public class QuestionController {
    @Resource
    QuestionService questionService;
    @GetMapping("/question/{id}")
    public String question(@PathVariable("id") Integer id, Model model) {
        QuestionDTO questiondto = questionService.findById(id);
        model.addAttribute("question",questiondto);
        return "question";
    }
}
