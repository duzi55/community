package xyz.sdju.community.exception;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-08-09 14:34
 */
public enum  CustimizeErrorCode implements CustimizeErrorCodeInterface{
    QUESTION_NOT_FIND(2001,"话题不存在了，换个试试啊"),
    QUESTIONID_NOT_FIND(2002,"话题或评论不存在了，换个试试啊"),
    NOT_LOGIN(2003,"用户未登录，登录后再试");
    private String message;
    private Integer code;

    CustimizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
