package megabooks.megabooks.domain.book.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import megabooks.megabooks.domain.book.service.BookService;
import megabooks.megabooks.global.reponse.CustomResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/member/book")
@Tag(name = "Book", description = "책 관련 API")
@RequiredArgsConstructor
@Slf4j
public class BookApiController {
    private final BookService bookService;
    @GetMapping("/findAllByMonthlyBest")
    @Operation(summary = "책 월간 베스트 전체 조회", description = "책 월간 베스트 전체 조회합니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "SUCCESS", content = @Content(schema = @Schema(implementation = BookResponseDTO.BookFindOneDTO.class)))
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<?> findAllByMonthlyBest(Pageable pageable) {
        return ResponseEntity.ok().body(CustomResponse.SUCCESS(HttpStatus.CREATED.value(), bookService.findAllByMonthlyBest(pageable)));
    }

    @GetMapping("/findAllByWeeklyBest")
    @Operation(summary = "책 주간 베스트 전체 조회", description = "책 주간 베스트 전체 조회합니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "SUCCESS", content = @Content(schema = @Schema(implementation = BookResponseDTO.BookFindOneDTO.class)))
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<?> findAllByWeeklyBest(Pageable pageable) {
        return ResponseEntity.ok().body(CustomResponse.SUCCESS(HttpStatus.CREATED.value(), bookService.findAllByWeeklyBest(pageable)));
    }

    @GetMapping("/findDetail/{bookId}")
    @Operation(summary = "책 상세 조회", description = "책 상세 조회합니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "SUCCESS", content = @Content(schema = @Schema(implementation = BookResponseDTO.BookFindDetailDTO.class)))
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<?> findDetailByBookId(@PathVariable("bookId") Long bookId) {
        return ResponseEntity.ok().body(CustomResponse.SUCCESS(HttpStatus.CREATED.value(), bookService.findDetailByBookId(bookId)));
    }
}
