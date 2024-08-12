package megabooks.megabooks.domain.user.dto;

import lombok.*;
import megabooks.megabooks.global.security.jwt.MegaBooksRole;

public class UserResponseDTO {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class UserFindDetailDTO {
        private Long userId;
        private String userEmail;
        private String userName;
        private MegaBooksRole megaBooksRole;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class UserFindOneDTO {
        private Long userId;
        private String userEmail;
        private String userName;
    }
}