package xyz.sdju.community.dto;

import lombok.Data;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-08-12 16:38
 */
@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private int type;
}
