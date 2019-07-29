package xyz.sdju.community.dto;

import lombok.Data;
import xyz.sdju.community.model.User;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-07-29 14:40
 */
@Data
public class QuestionDTO {
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
    private User user;
}
