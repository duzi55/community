package xyz.sdju.community.mapper;

import org.apache.ibatis.annotations.*;
import xyz.sdju.community.model.Question;

import java.util.List;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-07-28 16:02
 */
@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,tag) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    int create(Question question);

    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param("offset") Integer offset, @Param("size") Integer size);

    @Select("select count(1) from question")
    Integer count();

    @Select("select * from question where creator = #{userId} limit #{offset},#{size}")
    List<Question> listByUserId(@Param("userId") int userId, @Param("offset") Integer offset, @Param("size") Integer size);

    @Select("select count(1) from question where creator = #{userId}")
    Integer countByUserId(@Param("userId") int userId);

    @Select("select * from question where id = #{id}")
    Question findById(@Param("id") Integer id);

    @Update("update question set title = #{title}, description = #{description}, gmt_modified = #{gmtModified}, tag = #{tag} where id = #{id}")
    void update(Question question);

    @Update("update question set view_count = view_count + 1 where id = #{id}")
    void inView(@Param("id") Integer id);
}
