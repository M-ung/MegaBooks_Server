package megabooks.megabooks.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    /** 2XX **/
    OK(200, "Successful"),
    NO_MATCHING_CONTENTS(204, "NO CONTENT"),

    /** 4XX **/
    EMAIL_DUPLICATION_USER(400,"중복된 이메일입니다."),
    DUPLICATION_ORDER(400,"중복된 주문입니다."),
    NOT_FOUND_USER(404,"찾을 수 없는 회원입니다."),
    NOT_FOUND_ORDER(404,"찾을 수 없는 주문입니다."),
    NOT_FOUND_BOOK(404,"찾을 수 없는 책입니다."),
    NOT_FOUND_MY_BOOK(404,"찾을 수 없는 나의 책입니다."),
    NOT_FOUND_BOOK_CONTENT(404,"찾을 수 없는 책 내용입니다."),
    NOT_FOUND_USER_PROFILE(404,"찾을 수 없는 프로필입니다."),
    WRONG_TOKEN(401,  "잘못된 토큰입니다."),
    INVALID_PASSWORD_USER(401,  "비밀번호가 틀렸습니다."),
    ACCESS_DENIED(403,  "접근 권한이 없습니다."),
    NOT_ACTIVE_USER(403,  "회원이 ACTIVE가 아닙니다."),

    /** 5XX **/
    INTERNAL_SERVER_ERROR(500,"INTER SERVER ERROR");

    private int status;
    private String message;
}