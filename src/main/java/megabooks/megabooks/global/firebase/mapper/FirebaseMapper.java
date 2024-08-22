package megabooks.megabooks.global.firebase.mapper;

import megabooks.megabooks.global.firebase.dto.FirebaseResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FirebaseMapper {
    private static final ModelMapper modelMapper = new ModelMapper();
    public FirebaseResponseDTO.FirebaseFindSentenceDTO toFirebaseFindSentenceDTO(String sentence, String imageUrl, String audioUrl, Boolean isAir) {
        return FirebaseResponseDTO.FirebaseFindSentenceDTO.builder()
                .sentence(sentence)
                .imageUrl(imageUrl)
                .audioUrl(audioUrl)
                .isAir(isAir)
                .build();
    }

    public FirebaseResponseDTO.FirebaseFindBookContentDTO toFirebaseFindBookContentDTO(Long bookId, String findBookTitle, List<FirebaseResponseDTO.FirebaseFindSentenceDTO> sentenceDTOList) {
        return FirebaseResponseDTO.FirebaseFindBookContentDTO.builder()
                .bookId(bookId)
                .bookTitle(findBookTitle)
                .sentenceDTOList(sentenceDTOList)
                .build();
    }
}