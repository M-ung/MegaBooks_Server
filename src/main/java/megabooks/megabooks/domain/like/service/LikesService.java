package megabooks.megabooks.domain.like.service;

import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LikesService {
    Page<BookResponseDTO.BookFindOneDTO> findLikesAllByUserId(Long userId, Pageable pageable);
}