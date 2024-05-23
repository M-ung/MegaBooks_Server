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
import megabooks.megabooks.domain.orderBook.entity.OrderBookStatus;
import megabooks.megabooks.domain.orderBook.repository.OrderBookRepository;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.global.common.CommonMethod;
import megabooks.megabooks.global.common.exception.CustomException;
import megabooks.megabooks.global.common.reponse.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderBookRepository orderBookRepository;
    private final MyBookRepository myBookRepository;
    private final CommonMethod commonMethod;

    @Override
    @Transactional
    public OrderResponseDTO.OrderCreateDTO create(String userEmail, OrderRequestDTO.OrderCreateDTO orderCreateDTO) {
        try {
            log.info("[OrderServiceImpl] create");
            User findUser = commonMethod.getUser("email", userEmail);
            Book findBook = commonMethod.getBook_Id(orderCreateDTO.getBookId());

            commonMethod.existingMyBook(findUser, findBook);

            getMyBook(findUser, findBook);

            Order order = getOrder(findUser);

            int totalPrice = orderCreateDTO.getTotalPrice();
            int usingMileage = orderCreateDTO.getUsingMileage();

            OrderBook orderBook = getOrderBook(findBook, order, totalPrice, usingMileage);

            return new OrderResponseDTO.OrderCreateDTO(order, orderBook);
        } catch (CustomException ce){
            log.info("[CustomException] OrderServiceImpl create");
            throw ce;
        } catch (Exception e) {
            log.info("[Exception500] OrderServiceImpl create");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] OrderServiceImpl create : " + e.getMessage());
        }
    }

    private void getMyBook(User findUser, Book findBook) {
        MyBook myBook = new MyBook(findUser, findBook);
        myBookRepository.save(myBook);
    }

    @Override
    public OrderResponseDTO.OrderFindOneDTO findOne(Long orderId) {
        try {
            log.info("[OrderServiceImpl] findOne");
            return null;
        } catch (CustomException ce){
            log.info("[CustomException] OrderServiceImpl findOne");
            throw ce;
        } catch (Exception e) {
            log.info("[Exception500] OrderServiceImpl findOne");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] OrderServiceImpl findOne : " + e.getMessage());
        }
    }

    @Override
    public OrderResponseDTO.OrderFindAllDTO findAll(String userEmail) {
        try {
            log.info("[OrderServiceImpl] findAll");
            return null;
        } catch (CustomException ce){
            log.info("[CustomException] OrderServiceImpl findAll");
            throw ce;
        } catch (Exception e) {
            log.info("[Exception500] OrderServiceImpl findAll");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] OrderServiceImpl findAll : " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public OrderResponseDTO.OrderCancelDTO cancel(Long orderId) {
        try {
            log.info("[OrderServiceImpl] cancel");
            return null;
        } catch (CustomException ce){
            log.info("[CustomException] OrderServiceImpl cancel");
            throw ce;
        } catch (Exception e) {
            log.info("[Exception500] OrderServiceImpl cancel");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] OrderServiceImpl cancel : " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public OrderResponseDTO.OrderConfirmedDTO confirmed(Long orderId) {
        try {
            log.info("[OrderServiceImpl] confirmed");
            return null;
        } catch (CustomException ce){
            log.info("[CustomException] OrderServiceImpl confirmed");
            throw ce;
        } catch (Exception e) {
            log.info("[Exception500] OrderServiceImpl confirmed");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] OrderServiceImpl confirmed : " + e.getMessage());
        }
    }

    /** ================== 추가 메서드 ================== **/
    private OrderBook getOrderBook(Book findBook, Order order, int totalPrice, int usingMileage) {
        OrderBook orderBook = new OrderBook(totalPrice, usingMileage, OrderBookStatus.NOT_OPEN, order, findBook);
        orderBookRepository.save(orderBook);
        return orderBook;
    }

    private Order getOrder(User findUser) {
        Order order = new Order(OrderStatus.FINISH, findUser);
        orderRepository.save(order);
        return order;
    }
}
