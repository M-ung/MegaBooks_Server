package megabooks.megabooks.domain.order.repository;

import megabooks.megabooks.domain.order.entity.Order;
import megabooks.megabooks.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long>, OrderRepositoryCustom {
    Optional<Order> findByUserAndId(User user, Long orderId);
}
