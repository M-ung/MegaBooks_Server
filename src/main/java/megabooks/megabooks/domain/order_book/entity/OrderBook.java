package megabooks.megabooks.domain.order_book.entity;

import jakarta.persistence.*;
import lombok.Getter;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.order.entity.Order;
import megabooks.megabooks.global.common.BaseEntity;

@Entity
@Getter
public class OrderBook extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "order_book_id")
    private Long id;
    private Long totalPrice;
    private Long mileage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
}
