package xyz.sdju.community.service;

import org.springframework.stereotype.Service;
import xyz.sdju.community.exception.CustimizeErrorCode;
import xyz.sdju.community.exception.CustomizeException;
import xyz.sdju.community.model.Comment;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-08-12 18:19
 */
@Service
public class CommentService {

    public void inserst(Comment comment) {
        if (comment.getParentId() == 0 || comment.getParentId() == null) {
            throw new CustomizeException(CustimizeErrorCode.QUESTIONID_NOT_FIND);
        }
    }
}
