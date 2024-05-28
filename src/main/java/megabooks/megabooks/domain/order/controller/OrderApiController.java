package megabooks.megabooks.domain.order.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.order.dto.OrderRequestDTO;
import megabooks.megabooks.domain.order.dto.OrderResponseDTO;
import megabooks.megabooks.domain.order.service.OrderServiceImpl;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.global.auth.service.AuthenticationService;
import megabooks.megabooks.global.common.exception.Exception500;
import megabooks.megabooks.global.common.reponse.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/member/order")
@RequiredArgsConstructor
@Slf4j
public class OrderApiController {
    private final OrderServiceImpl orderService;
    private final AuthenticationService authenticationService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody OrderRequestDTO.OrderCreateDTO orderCreateDTO) {
        try {
            log.info("[OrderApiController] create");
            String userEmail = getUserEmail();
            OrderResponseDTO.OrderCreateDTO result = orderService.create(userEmail, orderCreateDTO);
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[SUCCESS] OrderApiController create", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] OrderApiController create");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    @GetMapping("/findOne/{orderId}")
    public ResponseEntity<?> findOne(@PathVariable("orderId") Long orderId) {
        try {
            log.info("[OrderApiController] findOne");
            String userEmail = getUserEmail();
            OrderResponseDTO.OrderFindOneDTO result = orderService.findOne(orderId);
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[SUCCESS] OrderApiController findOne", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] OrderApiController findOne");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    private String getUserEmail() {
        User user = authenticationService.getCurrentAuthenticatedUser();
        String userEmail = user.getUserEmail();
        return userEmail;
    }
}
