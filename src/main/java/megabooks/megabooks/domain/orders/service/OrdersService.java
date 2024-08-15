package megabooks.megabooks.domain.orders.service;

import megabooks.megabooks.domain.orders.dto.OrdersResponseDTO;

public interface OrdersService {
    // 주문 생성
    OrdersResponseDTO.OrderFindDetailDTO create(Long userId, Long bookId);
}