package megabooks.megabooks.domain.orders.dto;

import lombok.*;

public class OrdersResponseDTO {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class OrderFindDetailDTO {
        private Long orderId;
        private Long orderBookId;
        private Long userId;
        private Long bookId;
        private int totalPrice;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class OrderCheckDTO {
        private Boolean check;
    }
}
