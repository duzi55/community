package xyz.sdju.community.model;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-07-28 16:06
 */
@Data
public class Question {
    private Integer id;
    private String  title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private String tag;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
}
