package xyz.sdju.community.dto;

import lombok.Data;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-07-24 12:37
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;


}
