package xyz.sdju.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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

    @Select("select * from question")
    List<Question> list();
}
