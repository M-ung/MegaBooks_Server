package megabooks.megabooks.domain.book.service;

import megabooks.megabooks.domain.book.dto.BookRequestDTO;
import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    // 월간 베스트
    Page<BookResponseDTO.BookFindOneDTO> findAllByMonthlyBest(Pageable pageable);
    // 주간 베스트
    Page<BookResponseDTO.BookFindOneDTO> findAllByWeeklyBest(Pageable pageable);
}
