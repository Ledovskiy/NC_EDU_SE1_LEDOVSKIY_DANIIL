package fapi.web;

import fapi.dto.ErrorMessage;
import fapi.exeption.NotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalErrorController {

        @ExceptionHandler(NotFoundException.class)
        public ResponseEntity<ErrorMessage> handleNotFoundException(NotFoundException e) {
            ErrorMessage errorMessage = new ErrorMessage(404, 100, e.getMessage());
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
}
