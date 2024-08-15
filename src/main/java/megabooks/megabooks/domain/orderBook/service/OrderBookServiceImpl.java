package megabooks.megabooks.domain.orderBook.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.orders.entity.Order;
import megabooks.megabooks.domain.orderBook.entity.OrderBook;
import megabooks.megabooks.domain.orderBook.mapper.OrderBookMapper;
import megabooks.megabooks.domain.orderBook.repository.OrderBookRepository;
import megabooks.megabooks.domain.user.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class OrderBookServiceImpl implements OrderBookService{
    private final OrderBookRepository orderBookRepository;
    private final OrderBookMapper orderBookMapper;
    @Override
    public OrderBook create(Order order, Book book) {
        OrderBook orderBook = orderBookMapper.toOrderBookEntity(order, book);
        return orderBookRepository.save(orderBook);
    }

    @Override
    public boolean existsByUserAndBook(User user, Book book) {
        return orderBookRepository.existsByOrder_UserAndBook(user, book);
    }
}
