package megabooks.megabooks.domain.myBook.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.myBook.dto.MyBookResponseDTO;
import megabooks.megabooks.domain.myBook.service.MyBookServiceImpl;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.global.auth.service.AuthenticationService;
import megabooks.megabooks.global.common.exception.Exception500;
import megabooks.megabooks.global.common.reponse.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/member/myBook")
@RequiredArgsConstructor
@Slf4j
public class MyBookApiController {
    private final MyBookServiceImpl myBookService;
    private final AuthenticationService authenticationService;
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        try {
            log.info("[MyBookApiController] findAll");
            String userEmail = getUserEmail();
            MyBookResponseDTO.MyBookFindAll result = myBookService.findAll(userEmail);
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[SUCCESS] MyBookApiController findAll", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] MyBookApiController findAll");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }
    @PostMapping("/confirmed/{myBookId}")
    public ResponseEntity<?> confirmed(@PathVariable("myBookId") Long myBookId) {
        try {
            log.info("[MyBookApiController] confirmed");
            String userEmail = getUserEmail();
            MyBookResponseDTO.MyBookConfirmed result = myBookService.confirmed(userEmail, myBookId);
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[SUCCESS] MyBookApiController confirmed", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] MyBookApiController confirmed");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }
    private String getUserEmail() {
        User user = authenticationService.getCurrentAuthenticatedUser();
        String userEmail = user.getUserEmail();
        return userEmail;
    }
}
