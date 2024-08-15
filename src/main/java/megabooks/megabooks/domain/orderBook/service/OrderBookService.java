package megabooks.megabooks.domain.orderBook.service;

import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.orders.entity.Orders;
import megabooks.megabooks.domain.orderBook.entity.OrderBook;
import megabooks.megabooks.domain.user.entity.User;

public interface OrderBookService {
    OrderBook create(Orders orders, Book book);
    boolean existsByUserAndBook(User user, Book book);
}
