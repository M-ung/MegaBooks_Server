package megabooks.megabooks.domain.orders.repository;

import megabooks.megabooks.domain.orders.entity.Order;
import megabooks.megabooks.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long>, OrderRepositoryCustom {
    Optional<Order> findByUserAndOrderId(User user, Long orderId);
}
