package megabooks.megabooks.domain.order.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.order.dto.OrderResponseDTO;
import megabooks.megabooks.global.exception.ErrorCode;
import megabooks.megabooks.global.exception.order.OrderNotFoundException;

import java.util.List;
import static megabooks.megabooks.domain.Image.entity.QImage.image;
import static megabooks.megabooks.domain.order.entity.QOrder.order;
import static megabooks.megabooks.domain.orderBook.entity.QOrderBook.orderBook;
import static megabooks.megabooks.domain.user.entity.QUser.user;

@Slf4j
public class OrderRepositoryImpl implements OrderRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public OrderRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public OrderResponseDTO.OrderFindOneDTO findOne(Long orderId, String userEmail) {
        log.info("[OrderRepositoryImpl] findOne");
        OrderResponseDTO.OrderFindOneDTO result = queryFactory.select(Projections.constructor(OrderResponseDTO.OrderFindOneDTO.class,
                        order.id,
                        order.orderStatus,
                        user.id,
                        orderBook.book.id,
                        orderBook.id,
                        orderBook.totalPrice
                ))
                .from(order)
                .join(order.user, user)
                .join(orderBook).on(orderBook.order.id.eq(order.id))
                .where(order.id.eq(orderId).and(user.userEmail.eq(userEmail)))
                .fetchOne();

        if (result == null) {
            throw new OrderNotFoundException(ErrorCode.NOT_FOUND_ORDER);
        }

        List<String> bookUrlList = queryFactory.select(image.imageUrl)
                .from(image)
                .where(image.book.id.eq(result.getBookId()))
                .fetch();

        result.setBookUrlList(bookUrlList);
        return result;
    }

    @Override
    public OrderResponseDTO.OrderFindAllDTO findAll(String userEmail) {
        log.info("[OrderRepositoryImpl] findAll");
        List<OrderResponseDTO.OrderFindOneDTO> orderList = queryFactory.select(Projections.constructor(OrderResponseDTO.OrderFindOneDTO.class,
                        order.id,
                        order.orderStatus,
                        user.id,
                        orderBook.book.id,
                        orderBook.id,
                        orderBook.totalPrice
                ))
                .from(order)
                .join(order.user, user)
                .join(orderBook).on(orderBook.order.id.eq(order.id))
                .where(user.userEmail.eq(userEmail))
                .fetch();

        for (OrderResponseDTO.OrderFindOneDTO orderDTO : orderList) {
            List<String> bookUrlList = queryFactory.select(image.imageUrl)
                    .from(image)
                    .where(image.book.id.eq(orderDTO.getBookId()))
                    .fetch();
            orderDTO.setBookUrlList(bookUrlList);
        }

        return new OrderResponseDTO.OrderFindAllDTO(userEmail, orderList);
    }
}
