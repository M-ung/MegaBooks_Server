package megabooks.megabooks.domain.book.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import megabooks.megabooks.domain.book.service.BookService;
import megabooks.megabooks.global.reponse.CustomResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
    public CustomResponse<Page<BookResponseDTO.BookFindOneDTO>> findAllByMonthlyBest(Pageable pageable) {
        return CustomResponse.SUCCESS(HttpStatus.CREATED.value(), bookService.findAllByMonthlyBest(pageable));
    }

    @GetMapping("/findAllByWeeklyBest")
    @Operation(summary = "책 주간 베스트 전체 조회", description = "책 주간 베스트 전체 조회합니다.")
    public CustomResponse<Page<BookResponseDTO.BookFindOneDTO>> findAllByWeeklyBest(Pageable pageable) {
        return CustomResponse.SUCCESS(HttpStatus.CREATED.value(), bookService.findAllByWeeklyBest(pageable));
    }

    @GetMapping("/findDetail/{bookId}")
    @Operation(summary = "책 상세 조회", description = "책 상세 조회합니다.")
    public CustomResponse<BookResponseDTO.BookFindDetailDTO> findDetailByBookId(@PathVariable("bookId") Long bookId) {
        return CustomResponse.SUCCESS(HttpStatus.CREATED.value(), bookService.findDetailByBookId(bookId));
    }

    @GetMapping("/findAllByKeyword")
    @Operation(summary = "책 키워드 전체 조회", description = "책 키워드 전체 조회합니다.")
    public CustomResponse<Page<BookResponseDTO.BookFindOneDTO>> findAllByKeyword(@RequestParam(value = "keyword", required = false) String keyword, Pageable pageable) {
        return CustomResponse.SUCCESS(HttpStatus.CREATED.value(), bookService.findAllByKeyword(keyword, pageable));
    }
}
