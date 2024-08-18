package megabooks.megabooks.domain.likes.repository;

import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LikesRepositoryCustom {
    List<BookResponseDTO.BookFindOneDTO> findLikesAllByUserIdWithPageable(Long userId, Pageable pageable);
}
