package megabooks.megabooks.domain.book.service;

import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import megabooks.megabooks.domain.book.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    // 월간 베스트
    Page<BookResponseDTO.BookFindOneDTO> findAllByMonthlyBest(Pageable pageable);
    // 주간 베스트
    Page<BookResponseDTO.BookFindOneDTO> findAllByWeeklyBest(Pageable pageable);
    // 책 상세보기
    BookResponseDTO.BookFindDetailDTO findDetailByBookId(Long bookId);
    // 책 키워드 검색
    Page<BookResponseDTO.BookFindOneDTO> findAllByKeyword(String keyword, Pageable pageable);
    Book getBook_id(Long bookId);
}
