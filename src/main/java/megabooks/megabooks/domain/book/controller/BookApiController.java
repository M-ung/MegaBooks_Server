package megabooks.megabooks.domain.book.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import megabooks.megabooks.domain.book.service.BookServiceImpl;
import megabooks.megabooks.domain.user.dto.UserResponseDTO;
import megabooks.megabooks.global.common.exception.Exception500;
import megabooks.megabooks.global.common.reponse.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/member/book")
@RequiredArgsConstructor
@Slf4j
public class BookApiController {
    private final BookServiceImpl bookService;

    @GetMapping("/findOne/{bookId}")
    public ResponseEntity<?> findOne(@PathVariable Long bookId) {
        try {
            log.info("[BookApiController] findOne");
            BookResponseDTO.BookFindOneDTO result = bookService.findOne(bookId);
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[SUCCESS] BookApiController findOne", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] BookApiController findOne");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        try {
            log.info("[BookApiController] findAll");
            BookResponseDTO.BookFindAllDTO result = bookService.findAll();
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[SUCCESS] BookApiController findAll", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] BookApiController findAll");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }
}
