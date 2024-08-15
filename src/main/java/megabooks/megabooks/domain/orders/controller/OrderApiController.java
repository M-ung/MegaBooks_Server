package megabooks.megabooks.domain.orders.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.orders.dto.OrderResponseDTO;
import megabooks.megabooks.domain.orders.service.OrderService;
import megabooks.megabooks.global.reponse.CustomResponse;
import megabooks.megabooks.global.security.util.SecurityUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/member/order")
@Tag(name = "Order", description = "주문 관련 API")
@RequiredArgsConstructor
@Slf4j
public class OrderApiController {
    private final OrderService orderService;

    @PostMapping("/create/{bookId}")
    @Operation(summary = "책 주문", description = "책을 주문합니다.")
    public CustomResponse<OrderResponseDTO.OrderFindDetailDTO> create(@PathVariable("bookId") Long bookId) {
        return CustomResponse.SUCCESS(HttpStatus.CREATED.value(), orderService.create(SecurityUtil.getCurrentId(), bookId));
    }
}
