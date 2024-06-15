package megabooks.megabooks.global.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.book.repository.BookRepository;
import megabooks.megabooks.domain.myBook.entity.MyBook;
import megabooks.megabooks.domain.myBook.repository.MyBookRepository;
import megabooks.megabooks.domain.order.entity.Order;
import megabooks.megabooks.domain.order.repository.OrderRepository;
import megabooks.megabooks.domain.orderBook.entity.OrderBook;
import megabooks.megabooks.domain.orderBook.repository.OrderBookRepository;
import megabooks.megabooks.domain.token.entity.RefreshToken;
import megabooks.megabooks.domain.token.repository.RefreshTokenRepository;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.domain.user.repository.UserRepository;
import megabooks.megabooks.global.common.exception.CustomException;
import megabooks.megabooks.global.common.reponse.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CommonMethod {
    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final BookRepository bookRepository;
    private final MyBookRepository myBookRepository;
    private final OrderRepository orderRepository;
    private final OrderBookRepository orderBookRepository;
//
    /** User Method **/
    public User getUser(String identifier, Object value) throws CustomException {
        Optional<User> findUser = null;
        if (identifier.equals("email")) {
            findUser = userRepository.findByUserEmail((String) value);
        } else if (identifier.equals("id")) {
            findUser = userRepository.findById((Long) value);
        }

        if (findUser == null || !findUser.isPresent()) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        return findUser.get();
    }

    /** Refresh Method **/
    public RefreshToken getRefreshToken(String refreshToken) throws CustomException {
        Optional<RefreshToken> findRefreshToken = refreshTokenRepository.findById(refreshToken);
        if(!findRefreshToken.isPresent()) {
            throw new CustomException(ErrorCode.REFRESH_NOT_FOUND);
        }
        return findRefreshToken.get();
    }

    /** Book Method **/
    public Book getBook_Id(Long bookId) throws CustomException {
        Optional<Book> findBook = bookRepository.findById(bookId);
        if(!findBook.isPresent()) {
            throw new CustomException(ErrorCode.BOOK_NOT_FOUND);
        }
        return findBook.get();
    }

    /** MyBook Method **/
    public void existingMyBook(User user, Book book) throws CustomException {
        Optional<MyBook> findMyBook = myBookRepository.findByUserAndBook(user, book);
        if(findMyBook.isPresent()) {
            throw new CustomException(ErrorCode.MY_BOOK_EXIST);
        }
    }
    public MyBook getMyBook(User user, Book book) throws CustomException {
        Optional<MyBook> findMyBook = myBookRepository.findByUserAndBook(user, book);
        if(!findMyBook.isPresent()) {
            throw new CustomException(ErrorCode.MY_BOOK_NOT_FOUND);
        }
        return findMyBook.get();
    }
    public MyBook getMyBook_Id(Long myBookId) throws CustomException {
        Optional<MyBook> findMyBook = myBookRepository.findById(myBookId);
        if(!findMyBook.isPresent()) {
            throw new CustomException(ErrorCode.MY_BOOK_NOT_FOUND);
        }
        return findMyBook.get();
    }

    /** Order Method **/
    public Order getOrder_Id(Long orderId) throws CustomException {
        Optional<Order> findOrder = orderRepository.findById(orderId);
        if(!findOrder.isPresent()) {
            throw new CustomException(ErrorCode.ORDER_NOT_FOUND);
        }
        return findOrder.get();
    }

    /** OrderBook Method **/
    public OrderBook getOrderBook_Id(Long orderId) throws CustomException {
        Optional<OrderBook> findOrderBook = orderBookRepository.findByOrder_Id(orderId);
        if(!findOrderBook.isPresent()) {
            throw new CustomException(ErrorCode.ORDER_BOOK_NOT_FOUND);
        }
        return findOrderBook.get();
    }
}
