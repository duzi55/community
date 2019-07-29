package xyz.sdju.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import xyz.sdju.community.model.Question;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-07-28 16:02
 */
@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,tag) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    int create(Question question);
}
