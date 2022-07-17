package Default;

import Default.exception.LoginException;
import Default.exception.SeatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(SeatException.class)
    public ResponseEntity<Error> handleSeatException(SeatException e, WebRequest r) {
        Error error = new Error();
        error.setError(e.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<Error> handleLoginException(LoginException e, WebRequest r) {
        Error error = new Error();
        error.setError(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }

    static class Error {
        String error;

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
}
