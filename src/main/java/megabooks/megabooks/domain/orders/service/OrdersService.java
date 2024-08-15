package megabooks.megabooks.domain.orders.service;

import megabooks.megabooks.domain.orders.dto.OrdersResponseDTO;

public interface OrdersService {
    // 주문 생성
    OrdersResponseDTO.OrderFindDetailDTO create(Long userId, Long bookId);

    // 존재한 주문인지 확인
    OrdersResponseDTO.OrderCheckDTO check(Long userId, Long bookId);
}