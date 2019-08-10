package xyz.sdju.community.exception;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-08-09 14:11
 */
public class CustomizeException extends RuntimeException {
    String message;

    public CustomizeException(CustimizeErrorCodeInterface message) {
        this.message = message.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
