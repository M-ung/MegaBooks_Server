package megabooks.megabooks.global.firebase.dto;

import lombok.Builder;
import lombok.Data;

public class FirebaseResponseDTO {
    @Data
    @Builder
    public static class FirebaseFindSummaryDetailDTO {
        private String summaryImgUrl;
        private String summaryAudioUrl;
    }
}
