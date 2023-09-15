package com.csm.csmlogbook.web.exceptions;

import com.csm.csmlogbook.web.LogBookEntryController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestControllerAdvice(assignableTypes = LogBookEntryController.class)
public class DefaultExceptionHandler {

    @ExceptionHandler(ServiceNotAvailableException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<CustomExceptionBody> serviceNotAvailableException(ServiceNotAvailableException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        Timestamp time = Timestamp.valueOf(LocalDateTime.now());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(
                new CustomExceptionBody(time, status, e.getLocalizedMessage(), request),
                headers,
                status
        );
    }
}
