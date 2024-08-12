package megabooks.megabooks.domain.book.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.book.repository.BookRepository;
import megabooks.megabooks.global.exception.book.BookNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static megabooks.megabooks.global.exception.ErrorCode.NOT_FOUND_BOOK;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    @Override
    public Page<BookResponseDTO.BookFindOneDTO> findAllByMonthlyBest(Pageable pageable) {
        return bookRepository.findAllByMonthlyBestWithPageable(pageable);
    }

    @Override
    public Page<BookResponseDTO.BookFindOneDTO> findAllByWeeklyBest(Pageable pageable) {
        return bookRepository.findAllByWeeklyBestWithPageable(pageable);
    }

    @Override
    public BookResponseDTO.BookFindDetailDTO findDetailByBookId(Long bookId) {
        return bookRepository.findDetailByBookId(bookId);
    }

    @Override
    public Page<BookResponseDTO.BookFindOneDTO> findAllByKeyword(String keyword, Pageable pageable) {
        return bookRepository.findAllByKeywordWithPageable(keyword, pageable);
    }

    @Override
    public Book getBook_id(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(NOT_FOUND_BOOK));
    }
}