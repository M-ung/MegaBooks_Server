package megabooks.megabooks.global.exception;

import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.global.exception.book.BookNotFoundException;
import megabooks.megabooks.global.exception.user.UserEmailDuplicationException;
import megabooks.megabooks.global.exception.user.UserInvalidPasswordException;
import megabooks.megabooks.global.exception.user.UserNotActiveException;
import megabooks.megabooks.global.exception.user.UserNotFoundException;
import megabooks.megabooks.global.reponse.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionCustomAdvice {
    @ExceptionHandler(UserNotActiveException.class)
    public ResponseEntity<ApiErrorResponse> handleException(UserNotActiveException ex) {
        log.debug(ex.getMessage(), ex);
        return new ResponseEntity<>(
                new ApiErrorResponse(
                        ErrorCode.NOT_ACTIVE_USER.getStatus(),
                        ex.getMessage()),
                HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserEmailDuplicationException.class)
    public ResponseEntity<ApiErrorResponse> handleException(UserEmailDuplicationException ex) {
        log.debug(ex.getMessage(), ex);
        return new ResponseEntity<>(
                new ApiErrorResponse(
                        ErrorCode.EMAIL_DUPLICATION_USER.getStatus(),
                        ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserInvalidPasswordException.class)
    public ResponseEntity<ApiErrorResponse> handleException(UserInvalidPasswordException ex) {
        log.debug(ex.getMessage(), ex);
        return new ResponseEntity<>(
                new ApiErrorResponse(
                        ErrorCode.INVALID_PASSWORD_USER.getStatus(),
                        ex.getMessage()),
                HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleException(UserNotFoundException ex) {
        log.debug(ex.getMessage(), ex);
        return new ResponseEntity<>(
                new ApiErrorResponse(
                        ErrorCode.NOT_FOUND_USER.getStatus(),
                        ex.getMessage()),
                HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleException(BookNotFoundException ex) {
        log.debug(ex.getMessage(), ex);
        return new ResponseEntity<>(
                new ApiErrorResponse(
                        ErrorCode.NOT_FOUND_BOOK.getStatus(),
                        ex.getMessage()),
                HttpStatus.NOT_FOUND);
    }

    // 추가 예외 핸들러를 필요에 따라 추가할 수 있습니다
    @ExceptionHandler(Exception.class)
    public CustomResponse<?> handleException(Exception ex) {
        log.error("Unhandled exception: {}", ex.getMessage(), ex);
        return CustomResponse.ERROR(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}
