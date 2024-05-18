package megabooks.megabooks.domain.book.repository;

import megabooks.megabooks.domain.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom {
}
