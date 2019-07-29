package xyz.sdju.community.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
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

    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question question : questions) {
          User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        return questionDTOS;
    }
}
