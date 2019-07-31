package xyz.sdju.community.dto;

import lombok.Data;
import xyz.sdju.community.model.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-07-29 16:39
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questionDTOS;
    private boolean showPrevisous;
    private boolean showFirstPage;
    private boolean showNextPage;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;


    public void setPagination(Integer totalCount, Integer page, Integer size) {
        this.page = page;
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        pages.add(page);
        for (int i = 1; i < 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }

        }


        //是否展示上一页
        if (page == 1) {
            showPrevisous = false;
        } else {
            showPrevisous = true;
        }
        //是否展示下一页
        if (page == totalPage) {
            showNextPage = false;
        } else {
            showNextPage = true;
        }

        //判断是否展示首页
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }
        //判断是否展示尾页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}
