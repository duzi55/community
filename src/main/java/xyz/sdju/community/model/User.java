package xyz.sdju.community.model;

import lombok.Data;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-07-24 16:16
 */
@Data
public class User {
    private int id;
    private String name;
    private String accountId;
    private String token;
    private long gmtCreate;
    private long gmtModified;


}
