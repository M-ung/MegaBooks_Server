package megabooks.megabooks.domain.likes.service;

import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import megabooks.megabooks.domain.likes.dto.LikesResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LikesService {
    Page<BookResponseDTO.BookFindOneDTO> findLikesAllByUserId(Long userId, Pageable pageable);
    void toggle(Long bookId, Long userId);
    LikesResponseDTO.LikesCheckDTO check(Long userId, Long bookId);
}