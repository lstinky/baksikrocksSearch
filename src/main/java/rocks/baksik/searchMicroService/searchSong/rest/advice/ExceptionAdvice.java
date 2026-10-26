package rocks.baksik.searchMicroService.searchSong.rest.advice;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import rocks.baksik.searchMicroService.searchSong.dto.ErrorDto;
import rocks.baksik.searchMicroService.searchSong.exception.EntityNotFoundException;
import rocks.baksik.searchMicroService.searchSong.exception.ValueException;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("Invalid inpute data: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
            ValueException.NotFound.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorDto handleNotFoundException(EntityNotFoundException exception) {
        return new ErrorDto(exception.getErrorCode(), exception.getErrorMessage());
    }
}
