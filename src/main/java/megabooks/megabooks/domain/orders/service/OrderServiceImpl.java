package megabooks.megabooks.domain.orders.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.book.service.BookService;
import megabooks.megabooks.domain.orders.dto.OrderResponseDTO;
import megabooks.megabooks.domain.orders.entity.Order;
import megabooks.megabooks.domain.orders.mapper.OrderMapper;
import megabooks.megabooks.domain.orders.repository.OrderRepository;
import megabooks.megabooks.domain.orderBook.entity.OrderBook;
import megabooks.megabooks.domain.orderBook.service.OrderBookService;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.domain.user.service.UserService;
import megabooks.megabooks.global.exception.ErrorCode;
import megabooks.megabooks.global.exception.order.OrderDuplicationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final BookService bookService;
    private final OrderBookService orderBookService;
    private final OrderMapper orderMapper;

    @Override
    @Transactional
    public OrderResponseDTO.OrderFindDetailDTO create(Long userId, Long bookId) {
        User findUser = userService.getUser_Id(userId);
        Book findBook = bookService.getBook_id(bookId);

        checkExistUserAndBook(findUser, findBook);

        Order order = getOrder(findUser);

        OrderBook orderBook = orderBookService.create(order, findBook);

        return orderMapper.toOrderFindDetailDTO(findUser, orderBook);
    }

    private void checkExistUserAndBook(User findUser, Book findBook) {
        if (orderBookService.existsByUserAndBook(findUser, findBook)) {
            throw new OrderDuplicationException(ErrorCode.DUPLICATION_ORDER);
        }
    }

    private Order getOrder(User findUser) {
        Order order = orderMapper.toOrderEntity(findUser);
        orderRepository.save(order);
        return order;
    }
}
