package org.mygoal.fitnessapp.backend.config;

import org.mygoal.fitnessapp.backend.dto.ErrorDto;
import org.mygoal.fitnessapp.backend.exceptions.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles exceptions thrown by the application and converts them to HTTP responses with appropriate status codes and error messages.
 */
@ControllerAdvice
public class RestExceptionHandler {

    /**
     * Exception handler for the AppException class.
     * This method handles exceptions of type AppException and returns a ResponseEntity with error information.
     *
     * @param ex The AppException to be handled.
     * @return ResponseEntity with an ErrorDto object containing the error message and status.
     */
    @ExceptionHandler(value = { AppException.class })
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException(AppException ex) {
        return ResponseEntity
                .status(ex.getStatus())
                .body(ErrorDto.builder().message(ex.getMessage()).build());
    }
}
