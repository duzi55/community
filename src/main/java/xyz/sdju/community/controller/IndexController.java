package xyz.sdju.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.sdju.community.Service.QuestionService;
import xyz.sdju.community.dto.QuestionDTO;
import xyz.sdju.community.mapper.QuestionMapper;
import xyz.sdju.community.mapper.UserMapper;
import xyz.sdju.community.model.Question;
import xyz.sdju.community.model.User;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-07-24 09:24
 */
@Controller
public class IndexController {
    @Resource
    private UserMapper userMapper;
    @Resource
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest httpServletRequest,
                        Model model) {
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        httpServletRequest.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }

        List<QuestionDTO> questionDTOS = questionService.list();
        model.addAttribute("questiondtos",questionDTOS);
        return "index";
    }
}
