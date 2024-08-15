package megabooks.megabooks.domain.orders.repository;

import megabooks.megabooks.domain.orders.entity.Orders;
import megabooks.megabooks.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrdersRepository extends JpaRepository<Orders, Long>, OrdersRepositoryCustom {
}
