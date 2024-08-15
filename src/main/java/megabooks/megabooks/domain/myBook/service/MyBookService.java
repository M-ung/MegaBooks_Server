package megabooks.megabooks.domain.myBook.service;

import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.myBook.dto.MyBookResponseDTO;
import megabooks.megabooks.domain.myBook.entity.MyBook;
import megabooks.megabooks.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MyBookService {
    Page<MyBookResponseDTO.MyBookFindOneDTO> findAllByUserId(Long userId, Pageable pageable);
    void create(User user, Book book);
}
