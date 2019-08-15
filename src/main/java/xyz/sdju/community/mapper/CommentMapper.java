package xyz.sdju.community.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.sdju.community.model.Comment;
@Mapper
public interface CommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}