package megabooks.megabooks.domain.user.dto;

import lombok.Data;

@Data
public class UserRequestDTO {
    @Data
    public static class UserJoinDTO {
        private String userEmail;
        private String userPassword;
        private String userName;
    }
    @Data
    public static class UserLoginDTO {
        private String userEmail;
        private String userPassword;
    }
    @Data
    public static class UserUpdatePasswordDTO {
        private String userPassword;
    }
    @Data
    public class UserUpdateNameDTO {
        private String userName;
    }
}
