package megabooks.megabooks.domain.orders.entity;

import jakarta.persistence.*;
import lombok.*;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.global.entity.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orders extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private User user;

    private LocalDateTime orderDate;
}
