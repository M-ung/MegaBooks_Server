package megabooks.megabooks.global.firebase.service;

import megabooks.megabooks.global.firebase.dto.FirebaseResponseDTO;

public interface FirebaseService {

    FirebaseResponseDTO.FirebaseFindSummaryDetailDTO findDetailSummary(String bookTitle, String summary);
}
