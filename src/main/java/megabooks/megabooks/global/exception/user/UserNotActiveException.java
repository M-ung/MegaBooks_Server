package megabooks.megabooks.global.exception.user;

import lombok.Getter;
import megabooks.megabooks.global.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
public class UserNotActiveException extends RuntimeException {
    private final ErrorCode errorCode;
    public UserNotActiveException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}