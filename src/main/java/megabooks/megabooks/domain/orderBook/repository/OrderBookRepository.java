package megabooks.megabooks.domain.orderBook.repository;

import megabooks.megabooks.domain.orderBook.entity.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderBookRepository extends JpaRepository<OrderBook, Long> {
}
