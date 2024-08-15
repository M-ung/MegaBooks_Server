package megabooks.megabooks.domain.orderBook.repository;

import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.orderBook.entity.OrderBook;
import megabooks.megabooks.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderBookRepository extends JpaRepository<OrderBook, Long> {
    boolean existsByOrders_UserAndBook(User user, Book book);
}
