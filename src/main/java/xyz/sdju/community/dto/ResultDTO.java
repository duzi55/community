package xyz.sdju.community.dto;

import lombok.Data;
import xyz.sdju.community.exception.CustimizeErrorCode;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-08-12 17:31
 */
@Data
public class ResultDTO {
    private Integer code;
    private String message;

    public static ResultDTO errorOf(int code, String message) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static ResultDTO errorOf(CustimizeErrorCode notLogin) {
        return errorOf(notLogin.getCode(),notLogin.getMessage());
    }
    public static ResultDTO okOf(){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        return resultDTO;
    }
}
