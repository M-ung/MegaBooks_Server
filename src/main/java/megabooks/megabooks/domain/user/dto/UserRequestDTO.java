package megabooks.megabooks.domain.user.dto;

import lombok.Data;
import megabooks.megabooks.domain.user.entity.User;

@Data
public class UserRequestDTO {
    @Data
    public static class UserJoinDTO {
        private String userEmail;
        private String userPassword;
        private String userName;
        public User toEntity() {
            return new User(this.userEmail, this.userPassword, this.userName);
        }
    }
    @Data
    public static class UserUpdateDTO {
        private String userName;
        private String userImg;
    }
}
