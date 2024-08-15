package megabooks.megabooks.domain.likes.repository;

import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.likes.entity.Likes;
import megabooks.megabooks.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long>, LikesRepositoryCustom {
    Optional<Likes> findByUserAndBook(User user, Book book);
}
