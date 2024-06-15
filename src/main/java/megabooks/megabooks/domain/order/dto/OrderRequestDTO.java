package megabooks.megabooks.domain.order.dto;

import lombok.Data;

@Data
public class OrderRequestDTO {
    @Data
    public static class OrderCreateDTO {
        private Long bookId;
        private int totalPrice; // 총 결제 금액
    }
}
