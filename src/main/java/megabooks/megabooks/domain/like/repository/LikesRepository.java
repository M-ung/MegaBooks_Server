package megabooks.megabooks.domain.like.repository;

import megabooks.megabooks.domain.like.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes, Long>, LikesRepositoryCustom {
}
