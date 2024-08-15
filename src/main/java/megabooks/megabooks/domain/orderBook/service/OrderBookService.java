package megabooks.megabooks.domain.orderBook.service;

import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.orders.entity.Order;
import megabooks.megabooks.domain.orderBook.entity.OrderBook;
import megabooks.megabooks.domain.user.entity.User;

public interface OrderBookService {
    OrderBook create(Order order, Book book);
    boolean existsByUserAndBook(User user, Book book);
}
