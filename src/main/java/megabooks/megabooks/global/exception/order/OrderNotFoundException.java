package megabooks.megabooks.global.exception.order;

import lombok.Getter;
import megabooks.megabooks.global.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
public class OrderNotFoundException extends RuntimeException {
    private final ErrorCode errorCode;
    public OrderNotFoundException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}