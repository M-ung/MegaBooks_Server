package megabooks.megabooks.domain.orders.dto;

import lombok.*;

public class OrderResponseDTO {
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
}
