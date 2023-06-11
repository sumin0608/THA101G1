package tw.idv.ixercise.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tw.idv.ixercise.core.Core;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Core ex(Exception e) {
        e.printStackTrace();
        Core core = new Core();
        core.setSuccessful(false);
        core.setMessage("操作異常，請洽管理員");
        return core;
    }
}
