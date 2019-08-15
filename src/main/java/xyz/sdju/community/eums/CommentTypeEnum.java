package xyz.sdju.community.eums;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-08-12 18:17
 */
public enum CommentTypeEnum {
    QUSETION(1),
    COMMENT(2);
    private Integer type;

    public Integer getType() {
        return type;
    }

    CommentTypeEnum(Integer type) {
        this.type = type;
    }
}
