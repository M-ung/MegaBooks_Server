package megabooks.megabooks.domain.orders.service;

import megabooks.megabooks.domain.orders.dto.OrderResponseDTO;

public interface OrderService {
    // 주문 생성
    OrderResponseDTO.OrderFindDetailDTO create(Long userId, Long bookId);
}