package xyz.sdju.community.advice;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import xyz.sdju.community.exception.CustomizeException;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-08-09 13:59
 */
@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handler(Throwable ex, Model model) {
        System.out.println(ex.getMessage());
        if (ex instanceof CustomizeException) {
            model.addAttribute("message", ex.getMessage());
        } else {
            model.addAttribute("message", "服务器崩溃了，稍后再试呗.");
        }

        return new ModelAndView("error");
    }
}
