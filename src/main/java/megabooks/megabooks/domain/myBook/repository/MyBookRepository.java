package megabooks.megabooks.domain.myBook.repository;

import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.myBook.entity.MyBook;
import megabooks.megabooks.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MyBookRepository extends JpaRepository<MyBook, Long> {
    Optional<MyBook> findByUserAndBook(User user, Book book);
}
