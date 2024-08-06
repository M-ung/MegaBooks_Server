package megabooks.megabooks.domain.like.repository;

import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LikesRepositoryCustom {
    Page<BookResponseDTO.BookFindOneDTO> findLikesAllByUserIdWithPageable(Long userId, Pageable pageable);
}
