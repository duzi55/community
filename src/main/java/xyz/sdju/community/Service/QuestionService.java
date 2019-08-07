package xyz.sdju.community.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import xyz.sdju.community.dto.PaginationDTO;
import xyz.sdju.community.dto.QuestionDTO;
import xyz.sdju.community.mapper.QuestionMapper;
import xyz.sdju.community.mapper.UserMapper;
import xyz.sdju.community.model.Question;
import xyz.sdju.community.model.User;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-07-29 14:42
 */
@Service
public class QuestionService {
    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private UserMapper userMapper;

    public PaginationDTO list(Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount, page, size);
        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPage()) {
            page = paginationDTO.getTotalPage();
        }

        Integer offsize = size * (page - 1);
        List<Question> questions = questionMapper.list(offsize, size);
        List<QuestionDTO> questionDTOS = new ArrayList<>();

        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setQuestionDTOS(questionDTOS);
        return paginationDTO;
    }

    public PaginationDTO list(int userId, Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.countByUserId(userId);
        paginationDTO.setPagination(totalCount, page, size);
        if (page <= 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPage()&& paginationDTO.getTotalPage()!=0) {
            page = paginationDTO.getTotalPage();
        }

        Integer offsize = size * (page - 1);
        List<Question> questions = questionMapper.listByUserId(userId,offsize, size);
        List<QuestionDTO> questionDTOS = new ArrayList<>();

        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setQuestionDTOS(questionDTOS);
        return paginationDTO;
    }

    public QuestionDTO findById(Integer id) {
        Question question = questionMapper.findById(id);
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        User user = userMapper.findById(question.getCreator());
        questionDTO.setUser(user);
        return questionDTO;
    }
}
