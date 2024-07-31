package megabooks.megabooks.domain.user.dto;

import lombok.*;
import megabooks.megabooks.domain.user.entity.User;

@Data
public class UserResponseDTO {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class UserJoinDTO {
        private Long id;
        private String userEmail;
        private String userName;
        private String userImg;
        private String role;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class UserFindOneDTO {
        private Long id;
        private String userEmail;
        private String userName;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class UserDeleteDTO {
        private Long id;
        private String userEmail;
        private String userName;
        private String userImg;
        private String role;
    }
}