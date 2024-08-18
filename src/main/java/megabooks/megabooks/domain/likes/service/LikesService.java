package megabooks.megabooks.domain.likes.service;

import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import megabooks.megabooks.domain.likes.dto.LikesResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LikesService {
    List<BookResponseDTO.BookFindOneDTO> findLikesAllByUserId(Long userId, Pageable pageable);
    void toggle(Long bookId, Long userId);
    LikesResponseDTO.LikesCheckDTO check(Long userId, Long bookId);
}