package megabooks.megabooks.domain.orders.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.book.service.BookService;
import megabooks.megabooks.domain.myBook.service.MyBookService;
import megabooks.megabooks.domain.orders.dto.OrdersResponseDTO;
import megabooks.megabooks.domain.orders.entity.Orders;
import megabooks.megabooks.domain.orders.mapper.OrdersMapper;
import megabooks.megabooks.domain.orders.repository.OrdersRepository;
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
public class OrdersServiceImpl implements OrdersService {
    private final OrdersRepository ordersRepository;
    private final UserService userService;
    private final BookService bookService;
    private final MyBookService myBookService;
    private final OrderBookService orderBookService;
    private final OrdersMapper ordersMapper;

    @Override
    @Transactional
    public OrdersResponseDTO.OrderFindDetailDTO create(Long userId, Long bookId) {
        User findUser = userService.getUser_Id(userId);
        Book findBook = bookService.getBook_id(bookId);

        checkExistUserAndBook(findUser, findBook); // 이미 존재하는 주문인 지 확인

        Orders orders = getOrder(findUser); // 주문 생성

        OrderBook orderBook = orderBookService.create(orders, findBook); // 주문_책 생성

        myBookService.create(findUser, findBook); // 나의 책 생성

        findBook.plusDownloads(); // 책 다운로드 수 증가

        return ordersMapper.toOrderFindDetailDTO(findUser, orderBook);
    }

    @Override
    public OrdersResponseDTO.OrderCheckDTO check(Long userId, Long bookId) {
        User findUser = userService.getUser_Id(userId);
        Book findBook = bookService.getBook_id(bookId);

        return ordersMapper.toOrderCheckDTO(orderBookService.existsByUserAndBook(findUser, findBook));
    }

    private void checkExistUserAndBook(User findUser, Book findBook) {
        if (orderBookService.existsByUserAndBook(findUser, findBook)) {
            throw new OrderDuplicationException(ErrorCode.DUPLICATION_ORDER);
        }
    }

    private Orders getOrder(User findUser) {
        Orders orders = ordersMapper.toOrderEntity(findUser);
        ordersRepository.save(orders);
        return orders;
    }
}
