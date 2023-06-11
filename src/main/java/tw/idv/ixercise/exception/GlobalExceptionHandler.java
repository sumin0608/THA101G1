package tw.idv.ixercise.exception;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tw.idv.ixercise.core.Core;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Core ex(Exception e) {
        e.printStackTrace();
        Core core = new Core();
        core.setSuccessful(false);
        core.setMessage(e.getMessage());
        return core;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Core handleConstraintViolationException(ConstraintViolationException e) {
        e.printStackTrace();
        Core core = new Core();
        core.setSuccessful(false);

        StringBuilder messageBuilder = new StringBuilder();
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            messageBuilder.append(violation.getMessage());
        }
        String errorMessage = messageBuilder.toString().trim();

        core.setMessage(errorMessage);
        return core;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Core handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        e.printStackTrace();
        Core core = new Core();
        core.setSuccessful(false);

        StringBuilder messageBuilder = new StringBuilder();
        BindingResult bindingResult = e.getBindingResult();
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                messageBuilder.append(fieldError.getDefaultMessage()).append("\n");
            }
        }

        String errorMessage = messageBuilder.toString().trim();
        core.setMessage(errorMessage);
        return core;
    }
}
