package megabooks.megabooks.domain.orders.mapper;

import megabooks.megabooks.domain.orders.dto.OrderResponseDTO;
import megabooks.megabooks.domain.orders.entity.Order;
import megabooks.megabooks.domain.orderBook.entity.OrderBook;
import megabooks.megabooks.domain.user.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OrderMapper {
    private static final ModelMapper modelMapper = new ModelMapper();
    public Order toOrderEntity(User user) {
        return Order.builder()
                .user(user)
                .orderDate(LocalDateTime.now())
                .build();
    }

    public OrderResponseDTO.OrderFindDetailDTO toOrderFindDetailDTO(User user, OrderBook orderBook) {
        return OrderResponseDTO.OrderFindDetailDTO.builder()
                .orderId(orderBook.getOrder().getOrderId())
                .orderBookId(orderBook.getOrderBookId())
                .userId(user.getUserId())
                .bookId(orderBook.getBook().getBookId())
                .totalPrice(orderBook.getBook().getBookPrice())
                .build();
    }
}
