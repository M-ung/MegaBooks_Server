package megabooks.megabooks.domain.order.entity;

import jakarta.persistence.*;
import lombok.Getter;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.global.common.BaseEntity;

@Entity
@Getter
@Table(name = "orders")
public class Order extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private User user;

    protected Order() {
    }

    public Order(OrderStatus orderStatus, User user) {
        this.orderStatus = orderStatus;
        this.user = user;
    }
    public void updateOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

}
