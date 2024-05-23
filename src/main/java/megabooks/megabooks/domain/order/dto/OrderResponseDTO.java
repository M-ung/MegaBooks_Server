package megabooks.megabooks.domain.order.dto;

import lombok.Data;
import megabooks.megabooks.domain.order.entity.OrderStatus;

import java.util.List;

@Data
public class OrderResponseDTO {
    @Data
    public static class OrderDetails {
        private Long orderId;
        private OrderStatus orderStatus;
        private String userName;
        private String bookTitle;
        private String bookAuthor;
        private String bookPublisher;
        private int bookPrice;
        private String imageUrl;
        private int userMileage; // 사용자 마일리지
        private int usingMileage; // 사용한 마일리지
        private int totalPrice; // 총 결제 금액
    }

    @Data
    public static class OrderCreateDTO extends OrderDetails {
        private Long userId;
    }

    @Data
    public static class OrderFindOneDTO extends OrderDetails {
        // No additional fields
    }

    @Data
    public static class OrderFindAllDTO {
        private Long userId;
        private String userEmail;
        private List<OrderFindOneDTO> orderList;
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
