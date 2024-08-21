package megabooks.megabooks.domain.myBook.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.book.service.BookService;
import megabooks.megabooks.domain.myBook.dto.MyBookRequestDTO;
import megabooks.megabooks.domain.myBook.dto.MyBookResponseDTO;
import megabooks.megabooks.domain.myBook.entity.MyBook;
import megabooks.megabooks.domain.myBook.mapper.MyBookMapper;
import megabooks.megabooks.domain.myBook.repository.MyBookRepository;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.global.exception.book.BookNotFoundException;
import megabooks.megabooks.global.exception.myBook.MyBookNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static megabooks.megabooks.global.exception.ErrorCode.NOT_FOUND_BOOK;
import static megabooks.megabooks.global.exception.ErrorCode.NOT_FOUND_MY_BOOK;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class MyBookServiceImpl implements MyBookService {
    private final MyBookRepository myBookRepository;
    private final MyBookMapper myBookMapper;
    private final BookService bookService;

    @Override
    public List<MyBookResponseDTO.MyBookFindOneDTO> findAllByUserId(Long userId, Pageable pageable) {
        return myBookRepository.findAllByUserIdWithPageable(userId, pageable);
    }

    @Override
    @Transactional
    public void create(User user, Book book) {
        myBookRepository.save(myBookMapper.toMyBookEntity(user,book));
    }

    @Override
    @Transactional
    public void updateProcess(MyBookRequestDTO.MyBookProcessDTO myBookProcessDTO) {
        MyBook findMyBook = getMyBook_id(myBookProcessDTO.getMyBookId());
        findMyBook.updateMyBookProcess(myBookProcessDTO);
    }

    @Override
    public MyBook getMyBook_id(Long myBookId) {
        return myBookRepository.findById(myBookId)
                .orElseThrow(() -> new MyBookNotFoundException(NOT_FOUND_MY_BOOK));
    }
}
