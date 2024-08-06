package megabooks.megabooks.domain.book.repository;

import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookRepositoryCustom {
    // 월간 베스트 조회
    Page<BookResponseDTO.BookFindOneDTO> findAllByMonthlyBestWithPageable(Pageable pageable);

    // 주간 베스트 조회
    Page<BookResponseDTO.BookFindOneDTO> findAllByWeeklyBestWithPageable(Pageable pageable);
}
