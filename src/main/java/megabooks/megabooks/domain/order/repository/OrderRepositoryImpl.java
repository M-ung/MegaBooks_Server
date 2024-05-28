package megabooks.megabooks.domain.order.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import megabooks.megabooks.domain.order.dto.OrderResponseDTO;
import megabooks.megabooks.global.common.exception.CustomException;
import megabooks.megabooks.global.common.reponse.ErrorCode;
import java.util.Optional;
import static megabooks.megabooks.domain.book.entity.QBook.book;
import static megabooks.megabooks.domain.order.entity.QOrder.order;
import static megabooks.megabooks.domain.orderBook.entity.QOrderBook.orderBook;
import static megabooks.megabooks.domain.user.entity.QUser.user;

public class OrderRepositoryImpl implements OrderRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    public OrderRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
    @Override
    public OrderResponseDTO.OrderFindOneDTO findOne(Long orderId, String userEmail) {
        OrderResponseDTO.OrderFindOneDTO result = queryFactory
                .select(Projections.constructor(OrderResponseDTO.OrderFindOneDTO.class,
                        order.id,
                        order.orderStatus,
                        user.id,
                        book.id,
                        orderBook.id,
                        orderBook.usingMileage,
                        orderBook.totalPrice))
                .from(orderBook)
                .leftJoin(orderBook.order, order)
                .leftJoin(order.user, user)
                .leftJoin(orderBook.book, book)
                .where(order.id.eq(orderId)
                        .and(user.userEmail.eq(userEmail)))
                .fetchOne();

        if (result == null) {
            throw new CustomException(ErrorCode.ORDER_NOT_FOUND);
        }

        return result;
    }
    @Override
    public OrderResponseDTO.OrderFindAllDTO findAll(String userEmail) {
        return null;
    }
}
