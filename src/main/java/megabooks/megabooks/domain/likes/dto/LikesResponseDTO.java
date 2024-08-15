package megabooks.megabooks.domain.likes.dto;

import lombok.*;

public class LikesResponseDTO {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class LikesCheckDTO {
        private boolean check;
    }
}
