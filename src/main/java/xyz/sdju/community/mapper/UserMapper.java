package xyz.sdju.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xyz.sdju.community.model.User;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-07-24 16:14
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified,avatar_url) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
     void insert(User user);
    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);//当输入参数不是类就需要param注解
}
