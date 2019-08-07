package xyz.sdju.community.service;

import org.springframework.stereotype.Service;
import xyz.sdju.community.mapper.UserMapper;
import xyz.sdju.community.model.User;

import javax.annotation.Resource;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-08-07 10:32
 */
@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    public void createUser(User user) {
        User dbuser = userMapper.findByAccountId(user.getAccountId());
        if(dbuser == null){
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        }else {
            dbuser.setGmtCreate(System.currentTimeMillis());
            dbuser.setGmtModified(user.getGmtCreate());
            dbuser.setAvatarUrl(user.getAvatarUrl());
            dbuser.setBio(user.getBio());
            dbuser.setName(user.getName());
            userMapper.update(dbuser);
        }
    }
}
