package megabooks.megabooks.domain.order.service;

import megabooks.megabooks.domain.order.dto.OrderRequestDTO;
import megabooks.megabooks.domain.order.dto.OrderResponseDTO;

public interface OrderService {
    // 주문 생성
    OrderResponseDTO.OrderCreateDTO create(OrderRequestDTO.OrderCreateDTO orderCreateDTO);
    // 주문 조회
    OrderResponseDTO.OrderFindOneDTO findOne(Long orderId);
    // 주문 전체 조회
    OrderResponseDTO.OrderFindAllDTO findAll(String userEmail);
    // 주문 취소
    OrderResponseDTO.OrderCancelDTO cancel(Long orderId);
    // 주문 확정 (7일 후)
    OrderResponseDTO.OrderConfirmedDTO confirmed(Long orderId);
}
