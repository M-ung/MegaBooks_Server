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

}
