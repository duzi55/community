package xyz.sdju.community.exception;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-08-09 14:34
 */
public enum  CustimizeErrorCode implements CustimizeErrorCodeInterface{
    QUESTION_NOT_FIND("话题不存在了，换个试试啊");
    private String message;
    CustimizeErrorCode(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
