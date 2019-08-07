package xyz.sdju.community.mapper;

import org.apache.ibatis.annotations.*;
import xyz.sdju.community.model.User;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-07-24 16:14
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified,avatar_url,bio) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl},#{bio})")
     void insert(User user);

    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);//当输入参数不是类就需要param注解

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer creator);

    @Select("select * from user where account_id = #{accountId}")
    User findByAccountId(@Param("accountId") String accountId);

    @Update("update user set name = #{name},token = #{token},gmt_create = #{gmtCreate},gmt_modified = #{gmtModified},avatar_url = #{avatarUrl},bio = #{bio}")
    void update(User user);
}
