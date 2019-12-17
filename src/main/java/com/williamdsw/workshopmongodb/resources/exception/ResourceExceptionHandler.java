package com.williamdsw.workshopmongodb.resources.exception;

import com.williamdsw.workshopmongodb.services.exception.ObjectNotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author William
 */

@ControllerAdvice
public class ResourceExceptionHandler
{
    @ExceptionHandler (ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound (ObjectNotFoundException exception, HttpServletRequest request)
    {
        long timestamp = System.currentTimeMillis ();
        HttpStatus status = HttpStatus.NOT_FOUND;
        String errorHeader = "Não encontrado";
        StandardError error = new StandardError (timestamp, status.value (), errorHeader, exception.getMessage (), request.getRequestURI ());
        return ResponseEntity.status (status).body (error);
    }
}