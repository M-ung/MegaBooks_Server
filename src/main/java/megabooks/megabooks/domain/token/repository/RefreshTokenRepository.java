package megabooks.megabooks.domain.token.repository;

import megabooks.megabooks.domain.token.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
