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
        private int totalPrice; // 총 결제 금액
    }

    @Data
    public static class OrderFindOneDTO{
        private Long orderId;
        private OrderStatus orderStatus;
        private Long userId;
        private Long bookId;
        private Long orderBookId;
        private int totalPrice; // 총 결제 금액
        private List<String> bookUrlList;
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
        private Long orderId;
        private OrderStatus orderStatus;
        private String userEmail;
        private String bookTitle;
        private int totalPrice; // 총 결제 금액
    }

    @Data
    public static class OrderConfirmedDTO {
        private Long orderId;
        private OrderStatus orderStatus;
        private String userEmail;
        private String bookTitle;
        private int totalPrice; // 총 결제 금액
    }
}
