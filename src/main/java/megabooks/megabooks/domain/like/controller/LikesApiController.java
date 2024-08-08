package megabooks.megabooks.domain.like.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import megabooks.megabooks.domain.like.service.LikesService;
import megabooks.megabooks.global.reponse.CustomResponse;
import megabooks.megabooks.global.security.util.SecurityUtil;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/member/likes")
@Tag(name = "Likes", description = "좋아요 관련 API")
@RequiredArgsConstructor
@Slf4j
public class LikesApiController {
    private final LikesService likesService;

    @GetMapping("/likes")
    @Operation(summary = "관심 등록 전체 조회", description = "관심 등록 전체 조회합니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "SUCCESS", content = @Content(schema = @Schema(implementation = BookResponseDTO.BookFindOneDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = CustomResponse.class))),
            @ApiResponse(responseCode = "404", description = "Data Not Found", content = @Content(schema = @Schema(implementation = CustomResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = CustomResponse.class)))
    })
    public ResponseEntity<?> findLikesAllByUserId(Pageable pageable) {
        return ResponseEntity.ok().body(CustomResponse.SUCCESS(HttpStatus.CREATED.value(), likesService.findLikesAllByUserId(SecurityUtil.getCurrentId(), pageable)));
    }
}
