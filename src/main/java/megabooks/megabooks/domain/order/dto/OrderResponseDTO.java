package megabooks.megabooks.domain.order.dto;

import lombok.Data;
import megabooks.megabooks.domain.order.entity.Order;
import megabooks.megabooks.domain.order.entity.OrderStatus;
import megabooks.megabooks.domain.orderBook.entity.OrderBook;

import java.util.List;

@Data
public class OrderResponseDTO {
    @Data
    public static class OrderDetails {
        private Long orderId;
        private OrderStatus orderStatus;
        private Long userId;
        private Long bookId;
        private Long orderBookId;
        private int usingMileage; // 사용한 마일리지
        private int totalPrice; // 총 결제 금액
    }

    @Data
    public static class OrderCreateDTO extends OrderDetails {
        public OrderCreateDTO(Order order, OrderBook orderBook) {
            this.setOrderId(order.getId());
            this.setOrderStatus(order.getOrderStatus());
            this.setUserId(order.getUser().getId());
            this.setBookId(orderBook.getBook().getId());
            this.setOrderBookId(orderBook.getId());
            this.setUsingMileage(orderBook.getUsingMileage());
            this.setTotalPrice(orderBook.getTotalPrice());
        }
    }

    @Data
    public static class OrderFindOneDTO extends OrderDetails {
        public OrderFindOneDTO(Long orderId, OrderStatus orderStatus, Long userId, Long bookId, Long orderBookId, int usingMileage, int totalPrice) {
            this.setOrderId(orderId);
            this.setOrderStatus(orderStatus);
            this.setUserId(userId);
            this.setBookId(bookId);
            this.setOrderBookId(orderBookId);
            this.setUsingMileage(usingMileage);
            this.setTotalPrice(totalPrice);
        }
    }

    @Data
    public static class OrderFindAllDTO {
        private String userEmail;
        private List<OrderFindOneDTO> orderList;

        public OrderFindAllDTO(String userEmail, List<OrderFindOneDTO> orderList) {
            this.userEmail = userEmail;
            this.orderList = orderList;
        }
    }

    @Data
    public static class OrderCancelDTO extends OrderDetails {
        // No additional fields
    }

    @Data
    public static class OrderConfirmedDTO extends OrderDetails {
        // No additional fields
    }
}
