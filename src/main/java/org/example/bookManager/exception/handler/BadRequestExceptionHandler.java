package org.example.bookManager.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@RestControllerAdvice
public class BadRequestExceptionHandler {

    private static final Logger logger
            = Logger.getLogger(BadRequestExceptionHandler.class.getName());

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<List<BadRequest>> handleRequestBodyException(
            MethodArgumentNotValidException exception) {
        List<BadRequest> badRequests = new ArrayList<>();
        if (exception.getBindingResult().hasErrors()) {
            logger.warning(Objects.requireNonNull(
                    exception.getBindingResult().getFieldError()).getDefaultMessage());
            exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
                String field = fieldError.getField();
                String message = fieldError.getDefaultMessage();
                badRequests.add(new BadRequest(field, message));
            });
        }
        return ResponseEntity.badRequest().body(badRequests);
    }
}
