package xyz.sdju.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.sdju.community.mapper.QuestionMapper;
import xyz.sdju.community.mapper.UserMapper;
import xyz.sdju.community.model.Question;
import xyz.sdju.community.model.User;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-07-28 14:45
 */
@Controller
public class PublishController {
    @Resource
    private QuestionMapper questionMapper;
    @Autowired
    UserMapper userMapper;

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(@RequestParam("title") String title,
                            @RequestParam("description") String description,
                            @RequestParam("tag") String tag,
                            HttpServletRequest httpServletRequest,
                            Model model) {
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);
        if (title == null || title == "") {
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }
        if (description == null || description == "") {
            model.addAttribute("error", "内容不能为空");
            return "publish";
        }
        if (tag == null || tag == "") {
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }
        User user = null;
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {

            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    user = userMapper.findByToken(cookie.getValue());
                    if (user != null) {
                        question.setCreator(user.getId());
                    } else {
                        model.addAttribute("error", "用户未登录");
                        return "publish";
                    }
                    break;
                }

            }
        }
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        questionMapper.create(question);
        return "redirect:/";
    }
}
