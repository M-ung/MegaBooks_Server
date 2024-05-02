package megabooks.megabooks.domain.user.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserResponseDTO {
    @Setter
    @Getter
    public static class UserFindOneDTO {
        private Long id;
        private String userEmail;
        private String userName;
        private String userImg;
        private String role;
        private int userMileage;

        public UserFindOneDTO(Long id, String userEmail, String userName, String userImg, String role, int userMileage) {
            this.id = id;
            this.userEmail = userEmail;
            this.userName = userName;
            this.userImg = userImg;
            this.role = role;
            this.userMileage = userMileage;
        }
    }
}