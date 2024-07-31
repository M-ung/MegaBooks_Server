package megabooks.megabooks.domain.order.entity;

import jakarta.persistence.*;
import lombok.*;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.global.entity.BaseEntity;

@Entity
@Getter
@Builder
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long orderId;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private User user;
}
