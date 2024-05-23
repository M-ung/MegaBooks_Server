package megabooks.megabooks.domain.myBook.repository;

import megabooks.megabooks.domain.myBook.entity.MyBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyBookRepository extends JpaRepository<MyBook, Long> {
}
