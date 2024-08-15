package megabooks.megabooks.domain.orderBook.mapper;

import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.orders.entity.Orders;
import megabooks.megabooks.domain.orderBook.entity.OrderBook;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderBookMapper {
    private static final ModelMapper modelMapper = new ModelMapper();
    public OrderBook toOrderBookEntity(Orders orders, Book book) {
        return OrderBook.builder()
                .totalPrice(book.getBookPrice())
                .orders(orders)
                .book(book)
                .build();
    }
}
