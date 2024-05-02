package megabooks.megabooks.domain.user.dto;

import lombok.Data;

@Data
public class UserRequestDTO {
    @Data
    public static class UserUpdateDTO {
        private String userName;
        private String userImg;
    }
}
