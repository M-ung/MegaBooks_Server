package megabooks.megabooks.domain.order.dto;

import lombok.Data;
import megabooks.megabooks.domain.order.entity.Order;
import megabooks.megabooks.domain.order.entity.OrderStatus;
import megabooks.megabooks.domain.orderBook.entity.OrderBook;

import java.util.List;

@Data
public class OrderResponseDTO {
    @Data
    public static class OrderCreateDTO{
        private Long orderId;
        private OrderStatus orderStatus;
        private String userEmail;
        private String bookTitle;
        private int usingMileage; // 사용한 마일리지
        private int totalPrice; // 총 결제 금액

        public OrderCreateDTO(Order order, OrderBook orderBook) {
            this.orderId = order.getId();
            this.orderStatus = order.getOrderStatus();
            this.userEmail = order.getUser().getUserEmail();
            this.bookTitle =  orderBook.getBook().getBookTitle();
            this.usingMileage = orderBook.getUsingMileage();
            this.totalPrice = orderBook.getTotalPrice();
        }
    }

    @Data
    public static class OrderFindOneDTO{
        private Long orderId;
        private OrderStatus orderStatus;
        private Long userId;
        private Long bookId;
        private Long orderBookId;
        private int usingMileage; // 사용한 마일리지
        private int totalPrice; // 총 결제 금액
        private List<String> bookUrlList;

        public OrderFindOneDTO(Long orderId, OrderStatus orderStatus, Long userId, Long bookId, Long orderBookId, int usingMileage, int totalPrice) {
            this.orderId = orderId;
            this.orderStatus = orderStatus;
            this.userId = userId;
            this.bookId = bookId;
            this.orderBookId = orderBookId;
            this.usingMileage = usingMileage;
            this.totalPrice = totalPrice;
        }

        public OrderFindOneDTO(Long orderId, OrderStatus orderStatus, Long userId, Long bookId, Long orderBookId, int usingMileage, int totalPrice, List<String> bookUrlList) {
            this.orderId = orderId;
            this.orderStatus = orderStatus;
            this.userId = userId;
            this.bookId = bookId;
            this.orderBookId = orderBookId;
            this.usingMileage = usingMileage;
            this.totalPrice = totalPrice;
            this.bookUrlList = bookUrlList;
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
    public static class OrderCancelDTO {
        // No additional fields
    }

    @Data
    public static class OrderConfirmedDTO {
        // No additional fields
    }
}
