package megabooks.megabooks.domain.orders.mapper;

import megabooks.megabooks.domain.orders.dto.OrdersResponseDTO;
import megabooks.megabooks.domain.orders.entity.Orders;
import megabooks.megabooks.domain.orderBook.entity.OrderBook;
import megabooks.megabooks.domain.user.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OrdersMapper {
    private static final ModelMapper modelMapper = new ModelMapper();
    public Orders toOrderEntity(User user) {
        return Orders.builder()
                .user(user)
                .orderDate(LocalDateTime.now())
                .build();
    }

    public OrdersResponseDTO.OrderFindDetailDTO toOrderFindDetailDTO(User user, OrderBook orderBook) {
        return OrdersResponseDTO.OrderFindDetailDTO.builder()
                .orderId(orderBook.getOrders().getOrderId())
                .orderBookId(orderBook.getOrderBookId())
                .userId(user.getUserId())
                .bookId(orderBook.getBook().getBookId())
                .totalPrice(orderBook.getBook().getBookPrice())
                .build();
    }

    public OrdersResponseDTO.OrderCheckDTO toOrderCheckDTO(boolean check) {
        return OrdersResponseDTO.OrderCheckDTO.builder()
                .check(check)
                .build();
    }
}
