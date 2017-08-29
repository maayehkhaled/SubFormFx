package hello.Inbound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by kmaayeh on 8/30/2017.
 */
@ControllerAdvice

public class ExceptionControllerAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
        error.setMessage(HttpStatus.UNPROCESSABLE_ENTITY.name());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
    }
}
