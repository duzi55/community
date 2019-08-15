package xyz.sdju.community.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.sdju.community.dto.CommentDTO;
import xyz.sdju.community.dto.ResultDTO;
import xyz.sdju.community.exception.CustimizeErrorCode;
import xyz.sdju.community.mapper.CommentMapper;
import xyz.sdju.community.model.Comment;
import xyz.sdju.community.model.User;
import xyz.sdju.community.service.CommentService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-08-12 16:32
 */
@Controller
public class CommentController {
    @Resource
    CommentService commentService;
    @ResponseBody
    @PostMapping("/comment")
    public Object post(@RequestBody CommentDTO commentDTO,
                       HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
//        if (user == null) {
//            return  ResultDTO.errorOf(CustimizeErrorCode.NOT_LOGIN);
//        }
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDTO, comment);
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
//        comment.setCommentator(user.getId());
        commentService.inserst(comment);
        return ResultDTO.okOf();
    }
}
