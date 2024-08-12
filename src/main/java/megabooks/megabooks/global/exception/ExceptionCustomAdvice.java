package megabooks.megabooks.global.exception;

import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.global.exception.book.BookNotFoundException;
import megabooks.megabooks.global.exception.user.UserEmailDuplicationException;
import megabooks.megabooks.global.exception.user.UserInvalidPasswordException;
import megabooks.megabooks.global.exception.user.UserNotFoundException;
import megabooks.megabooks.global.reponse.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionCustomAdvice {
    @ExceptionHandler(UserEmailDuplicationException.class)
    public CustomResponse<?> handleUserEmailDuplicationException(UserEmailDuplicationException ex) {
        log.error("User email duplication error: {}", ex.getMessage(), ex);
        return CustomResponse.ERROR(ErrorCode.EMAIL_DUPLICATION_USER);
    }

    @ExceptionHandler(UserInvalidPasswordException.class)
    public CustomResponse<?> handleUserInvalidPasswordException(UserInvalidPasswordException ex) {
        log.error("Invalid password error: {}", ex.getMessage(), ex);
        return CustomResponse.ERROR(ErrorCode.INVALID_PASSWORD_USER);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public CustomResponse<?> handleUserNotFoundException(UserNotFoundException ex) {
        log.error("User not found error: {}", ex.getMessage(), ex);
        return CustomResponse.ERROR(ErrorCode.NOT_FOUND_USER);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public CustomResponse<?> handleBookNotFoundException(BookNotFoundException ex) {
        log.error("User not found error: {}", ex.getMessage(), ex);
        return CustomResponse.ERROR(ErrorCode.NOT_FOUND_BOOK);
    }

    // 추가 예외 핸들러를 필요에 따라 추가할 수 있습니다
    @ExceptionHandler(Exception.class)
    public CustomResponse<?> handleException(Exception ex) {
        log.error("Unhandled exception: {}", ex.getMessage(), ex);
        return CustomResponse.ERROR(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}
