package megabooks.megabooks.domain.likes.service;

import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LikesService {
    Page<BookResponseDTO.BookFindOneDTO> findLikesAllByUserId(Long userId, Pageable pageable);
    void toggle(Long bookId, Long userId);
}