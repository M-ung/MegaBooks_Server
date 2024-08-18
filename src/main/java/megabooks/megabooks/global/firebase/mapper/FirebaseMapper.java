package megabooks.megabooks.global.firebase.mapper;

import megabooks.megabooks.global.firebase.dto.FirebaseResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FirebaseMapper {
    private static final ModelMapper modelMapper = new ModelMapper();
    public FirebaseResponseDTO.FirebaseFindSummaryDetailDTO toFirebaseFindSummaryDetailDTO(String summaryImgUrl, String summaryAudioUrl) {
        return FirebaseResponseDTO.FirebaseFindSummaryDetailDTO.builder()
                .summaryImgUrl(summaryImgUrl)
                .summaryAudioUrl(summaryAudioUrl)
                .build();
    }
}