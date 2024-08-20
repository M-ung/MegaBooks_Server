package megabooks.megabooks.global.firebase.service;

import megabooks.megabooks.global.firebase.dto.FirebaseResponseDTO;

public interface FirebaseService {
    FirebaseResponseDTO.FirebaseFindBookContentDTO findBookContentByBookId(Long bookId);
}
