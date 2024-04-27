package megabooks.megabooks.global.common.exception;

import lombok.Getter;
import megabooks.megabooks.global.common.reponse.ApiResponse;
import megabooks.megabooks.global.common.reponse.ErrorCode;

@Getter
public class CustomException extends RuntimeException {
    private String msg;
    private ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
    public CustomException(ErrorCode errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public ApiResponse<?> body(){
        return ApiResponse.FAILURE(errorCode.getCode(), "CustomException : " + errorCode.getMsg());
    }
}