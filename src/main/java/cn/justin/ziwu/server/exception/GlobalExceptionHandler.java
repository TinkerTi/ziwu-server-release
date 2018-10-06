package cn.justin.ziwu.server.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {TestException.class})
    public String handleException(TestException e) {
        System.out.println("test exception handler");
        return "";
    }

}
