package megabooks.megabooks.domain.likes.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import megabooks.megabooks.domain.likes.service.LikesService;
import megabooks.megabooks.global.reponse.CustomResponse;
import megabooks.megabooks.global.security.util.SecurityUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/member/likes")
@Tag(name = "Likes", description = "좋아요 관련 API")
@RequiredArgsConstructor
@Slf4j
public class LikesApiController {
    private final LikesService likesService;

    @GetMapping("/findLikesAllByUserId")
    @Operation(summary = "관심 등록 전체 조회", description = "관심 등록 전체 조회합니다.")
    public CustomResponse<Page<BookResponseDTO.BookFindOneDTO>> findLikesAllByUserId(Pageable pageable) {
        return CustomResponse.SUCCESS(HttpStatus.OK.value(), likesService.findLikesAllByUserId(SecurityUtil.getCurrentId(), pageable));
    }

    @PostMapping("/toggle/{bookId}")
    @Operation(summary = "관심 등록", description = "관심 등록합니다.")
    public CustomResponse<?> toggle(@PathVariable("bookId") Long bookId) {
        likesService.toggle(bookId, SecurityUtil.getCurrentId());
        return CustomResponse.SUCCESS(HttpStatus.OK.value());
    }
}
