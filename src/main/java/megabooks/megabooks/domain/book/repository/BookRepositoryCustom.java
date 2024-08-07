package megabooks.megabooks.domain.book.repository;

import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookRepositoryCustom {
    // 월간 베스트 조회
    Page<BookResponseDTO.BookFindOneDTO> findAllByMonthlyBestWithPageable(Pageable pageable);

    // 주간 베스트 조회
    Page<BookResponseDTO.BookFindOneDTO> findAllByWeeklyBestWithPageable(Pageable pageable);

    // 책 상세보기
    BookResponseDTO.BookFindDetailDTO findDetailByBookId(Long bookId);

    // 키워드 검색
    Page<BookResponseDTO.BookFindOneDTO> findAllByKeywordWithPageable(String keyword, Pageable pageable);
}
