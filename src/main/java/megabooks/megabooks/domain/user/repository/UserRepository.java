package megabooks.megabooks.domain.user.repository;

import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.domain.user.entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
    Optional<User> findByUserEmail(String userEmail);
    boolean existsByUserEmail(String userEmail);
    boolean existsByUserIdAndUserStatus(Long userId, UserStatus userStatus);
}
