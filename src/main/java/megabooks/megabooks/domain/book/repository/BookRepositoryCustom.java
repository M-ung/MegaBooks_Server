package megabooks.megabooks.domain.book.repository;

import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import megabooks.megabooks.domain.user.dto.UserResponseDTO;

public interface BookRepositoryCustom {
    BookResponseDTO.BookFindOneDTO findOne(Long bookId);
    BookResponseDTO.BookFindAllDTO findAll();
}
