package megabooks.megabooks.domain.user.dto;

import lombok.Data;
import megabooks.megabooks.domain.user.entity.User;

@Data
public class UserResponseDTO {
    @Data
    public static class UserJoinDTO {
        private Long id;
        private String userEmail;
        private String userName;
        private String userImg;
        private String role;
        public UserJoinDTO(Long id, String userEmail, String userName, String userImg, String role) {
            this.id = id;
            this.userEmail = userEmail;
            this.userName = userName;
            this.userImg = userImg;
            this.role = role;
        }

        public UserJoinDTO(User user) {
            this.id = user.getId();
            this.userEmail = user.getUserEmail();
            this.userName = user.getUserName();
            this.userImg = user.getUserImg();
            this.role = user.getRole();
        }
    }
    @Data
    public static class UserFindOneDTO {
        private Long id;
        private String userEmail;
        private String userName;
        private String userImg;
        private String role;
        public UserFindOneDTO(Long id, String userEmail, String userName, String userImg, String role) {
            this.id = id;
            this.userEmail = userEmail;
            this.userName = userName;
            this.userImg = userImg;
            this.role = role;
        }
    }

    @Data
    public static class UserUpdateDTO {
        private Long id;
        private String userEmail;
        private String userName;
        private String userImg;
        private String role;
        public UserUpdateDTO(User user) {
            this.id = user.getId();
            this.userEmail = user.getUserEmail();
            this.userName = user.getUserName();
            this.userImg = user.getUserImg();
            this.role = user.getRole();
        }
    }
    @Data
    public static class UserDeleteDTO {
        private Long id;
        private String userEmail;
        private String userName;
        private String userImg;
        private String role;
        public UserDeleteDTO(User user) {
            this.id = user.getId();
            this.userEmail = user.getUserEmail();
            this.userName = user.getUserName();
            this.userImg = user.getUserImg();
            this.role = user.getRole();
        }
    }
}