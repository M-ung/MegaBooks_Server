package megabooks.megabooks.global.firebase.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

public class FirebaseResponseDTO {
    @Data
    @Builder
    public static class FirebaseFindBookContentDTO {
        private Long bookId;
        private String bookTitle;
        private List<FirebaseFindSentenceDTO> sentenceDTOList;
    }

    @Data
    @Builder
    public static class FirebaseFindSentenceDTO {
        private String sentence;
        private String imageUrl;
        private String audioUrl;
        private Boolean isAir;
    }
}
