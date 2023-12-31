package jpapractice.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({IllegalArgumentException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ExceptionResponse handleError(Exception e) {
		return ExceptionResponse.of(String.valueOf(HttpStatus.BAD_REQUEST.value()), e.getMessage());
	}
}
