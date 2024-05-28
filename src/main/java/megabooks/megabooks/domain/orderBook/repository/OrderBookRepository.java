package megabooks.megabooks.domain.orderBook.repository;

import megabooks.megabooks.domain.orderBook.entity.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface OrderBookRepository extends JpaRepository<OrderBook, Long> {
    Optional<OrderBook> findByOrder_Id(Long orderId);
}
