package megabooks.megabooks.domain.orderBook.entity;

import jakarta.persistence.*;
import lombok.*;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.orders.entity.Orders;
import megabooks.megabooks.global.entity.BaseEntity;

@Entity
@Getter
@Builder
@Table(name = "order_book")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderBook extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "order_book_id")
    private Long orderBookId;
    private int totalPrice; // 총 결제 금액

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
}
