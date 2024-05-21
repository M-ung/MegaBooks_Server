package megabooks.megabooks.domain.book.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.book.dto.BookRequestDTO;
import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import megabooks.megabooks.domain.book.service.BookServiceImpl;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.global.auth.service.AuthenticationService;
import megabooks.megabooks.global.common.exception.Exception500;
import megabooks.megabooks.global.common.reponse.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/member/book")
@RequiredArgsConstructor
@Slf4j
public class BookApiController {
    private final BookServiceImpl bookService;
    private final AuthenticationService authenticationService;
    @PostMapping("/upload")
    public ResponseEntity<?> upload(@ModelAttribute BookRequestDTO.BookUploadDTO bookUploadDTO) {
        try {
            log.info("[BookApiController] upload");
            BookResponseDTO.BookUploadDTO result = bookService.upload(bookUploadDTO);
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[SUCCESS] BookApiController upload", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] BookApiController upload");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }
    @GetMapping("/findOne/{bookId}")
    public ResponseEntity<?> findOne(@PathVariable("bookId") Long bookId) {
        try {
            log.info("[BookApiController] findOne");
            BookResponseDTO.BookFindOneDTO result = bookService.findOne(bookId);
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[SUCCESS] BookApiController findOne", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] BookApiController findOne");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    @GetMapping("/findAllBook")
    public ResponseEntity<?> findAllBook() {
        try {
            log.info("[BookApiController] findAll");
            BookResponseDTO.BookFindAllDTO result = bookService.findAllBook();
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[SUCCESS] BookApiController findAll", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] BookApiController findAll");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    private String getUserEmail() {
        User user = authenticationService.getCurrentAuthenticatedUser();
        String userEmail = user.getUserEmail();
        return userEmail;
    }
}
