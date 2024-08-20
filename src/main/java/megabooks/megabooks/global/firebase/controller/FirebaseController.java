package megabooks.megabooks.global.firebase.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.global.firebase.dto.FirebaseResponseDTO;
import megabooks.megabooks.global.firebase.service.FirebaseService;
import megabooks.megabooks.global.reponse.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/member/firebase")
@Tag(name = "Firebase", description = "Firebase 관련 API")
@RequiredArgsConstructor
@Slf4j
public class FirebaseController {
    private final FirebaseService firebaseService;

    @GetMapping("/findBookContentByBookId/{bookId}")
    public CustomResponse<FirebaseResponseDTO.FirebaseFindBookContentDTO> findBookContentByBookId(@PathVariable("bookId") Long bookId) {
        return CustomResponse.SUCCESS(HttpStatus.OK.value(), firebaseService.findBookContentByBookId(bookId));
    }
}