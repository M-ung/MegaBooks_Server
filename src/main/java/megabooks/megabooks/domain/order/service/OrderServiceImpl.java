package megabooks.megabooks.domain.order.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.myBook.entity.MyBook;
import megabooks.megabooks.domain.myBook.repository.MyBookRepository;
import megabooks.megabooks.domain.order.dto.OrderRequestDTO;
import megabooks.megabooks.domain.order.dto.OrderResponseDTO;
import megabooks.megabooks.domain.order.entity.Order;
import megabooks.megabooks.domain.order.entity.OrderStatus;
import megabooks.megabooks.domain.order.repository.OrderRepository;
import megabooks.megabooks.domain.orderBook.entity.OrderBook;
import megabooks.megabooks.domain.orderBook.repository.OrderBookRepository;
import megabooks.megabooks.domain.user.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static megabooks.megabooks.domain.myBook.entity.MyBookStatus.NOT_OPEN;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderBookRepository orderBookRepository;
    private final MyBookRepository myBookRepository;

//    @Override
//    @Transactional
//    public OrderResponseDTO.OrderCreateDTO create(String userEmail, OrderRequestDTO.OrderCreateDTO orderCreateDTO) {
//        User findUser = commonMethod.getUser("email", userEmail);
//        Book findBook = commonMethod.getBook_Id(orderCreateDTO.getBookId());
//
//        commonMethod.existingMyBook(findUser, findBook);
//
//        getMyBook(findUser, findBook);
//
//        Order order = getOrder(findUser);
//
//        int totalPrice = orderCreateDTO.getTotalPrice();
//
//        OrderBook orderBook = getOrderBook(findBook, order, totalPrice);
//        findBook.increaseBookSales();
//
//        return new OrderResponseDTO.OrderCreateDTO(order, orderBook);
//    }
//
//    @Override
//    @Transactional
//    public OrderResponseDTO.OrderCancelDTO cancel(String userEmail, Long orderId) {
//        User findUser = commonMethod.getUser("email", userEmail);
//        Order findOrder = commonMethod.getOrder_Id(orderId);
//        OrderBook findOrderBook = commonMethod.getOrderBook_Id(orderId);
//        Book findBook = commonMethod.getBook_Id(findOrderBook.getBook().getId());
//
//        if (!findUser.getUserEmail().equals(userEmail)) {
//            throw new CustomException(ErrorCode.USER_DENIED);
//        }
//
//        findOrder.updateOrderStatus(OrderStatus.CANCEL);
//
//        MyBook findMyBook = commonMethod.getMyBook(findUser, findBook);
//        myBookRepository.delete(findMyBook);
//
//        // 환불해 주는 로직 필요!!!!
//
//        return new OrderResponseDTO.OrderCancelDTO(findOrderBook);
//    }
//
//    // 이 코드는 7일 뒤 자동으로 confirmed가 되게 짜야 함.
//    @Override
//    @Transactional
//    public OrderResponseDTO.OrderConfirmedDTO confirmed(String userEmail, Long orderId) {
//        User findUser = commonMethod.getUser("email", userEmail);
//        Order findOrder = commonMethod.getOrder_Id(orderId);
//        OrderBook findOrderBook = commonMethod.getOrderBook_Id(orderId);
//
//        if (!findUser.getUserEmail().equals(userEmail)) {
//            throw new CustomException(ErrorCode.USER_DENIED);
//        }
//
//        findOrder.updateOrderStatus(OrderStatus.CONFIRMED);
//
//        return new OrderResponseDTO.OrderConfirmedDTO(findOrderBook);
//    }
//
//    @Override
//    public OrderResponseDTO.OrderFindOneDTO findOne(Long orderId, String userEmail) {
//        Order findOrder = commonMethod.getOrder_Id(orderId);
//        if(!findOrder.getUser().getUserEmail().equals(userEmail)) {
//            throw new CustomException(ErrorCode.USER_DENIED);
//        }
//        return orderRepository.findOne(orderId, userEmail);
//    }
//
//    @Override
//    public OrderResponseDTO.OrderFindAllDTO findAll(String userEmail) {
//        return orderRepository.findAll(userEmail);
//    }
//
//    /** ================== 추가 메서드 ================== **/
//    private OrderBook getOrderBook(Book findBook, Order order, int totalPrice) {
//        OrderBook orderBook = new OrderBook(totalPrice, order, findBook);
//        orderBookRepository.save(orderBook);
//        return orderBook;
//    }
//
//    private Order getOrder(User findUser) {
//        Order order = new Order(OrderStatus.FINISH, findUser);
//        orderRepository.save(order);
//        return order;
//    }
//
//    private void getMyBook(User findUser, Book findBook) {
//        MyBook myBook = new MyBook(findUser, findBook, NOT_OPEN);
//        myBookRepository.save(myBook);
//    }
}
