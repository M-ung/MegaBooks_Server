package megabooks.megabooks.domain.myBook.service;

import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.myBook.dto.MyBookRequestDTO;
import megabooks.megabooks.domain.myBook.dto.MyBookResponseDTO;
import megabooks.megabooks.domain.myBook.entity.MyBook;
import megabooks.megabooks.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MyBookService {
    List<MyBookResponseDTO.MyBookFindOneDTO> findAllByUserId(Long userId, Pageable pageable);
    void create(User user, Book book);
    void updateProcess(MyBookRequestDTO.MyBookProcessDTO myBookProcessDTO);
    MyBook getMyBook_id(Long myBookId);
}
