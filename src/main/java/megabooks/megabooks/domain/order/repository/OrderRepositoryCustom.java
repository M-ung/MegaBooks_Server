package megabooks.megabooks.domain.order.repository;

import megabooks.megabooks.domain.order.dto.OrderResponseDTO;

public interface OrderRepositoryCustom {
    OrderResponseDTO.OrderFindOneDTO findOne(Long orderId, String userEmail);
    OrderResponseDTO.OrderFindAllDTO findAll(String userEmail);
}
