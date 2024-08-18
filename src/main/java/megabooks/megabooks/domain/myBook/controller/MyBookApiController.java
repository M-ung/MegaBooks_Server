package megabooks.megabooks.domain.myBook.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.myBook.dto.MyBookResponseDTO;
import megabooks.megabooks.domain.myBook.service.MyBookService;
import megabooks.megabooks.global.reponse.CustomResponse;
import megabooks.megabooks.global.security.util.SecurityUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/member/myBook")
@Tag(name = "MyBook", description = "내 서재 관련 API")
@RequiredArgsConstructor
@Slf4j
public class MyBookApiController {
    private final MyBookService myBookService;

    @GetMapping("/findAllByUserId")
    @Operation(summary = "내 서재 전체 조회", description = "내 서재 전체 조회합니다.")
    public CustomResponse<List<MyBookResponseDTO.MyBookFindOneDTO>> findAllByUserId(Pageable pageable) {
        return CustomResponse.SUCCESS(HttpStatus.CREATED.value(), myBookService.findAllByUserId(SecurityUtil.getCurrentId(), pageable));
    }
}
