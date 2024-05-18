package megabooks.megabooks.domain.book.repository;

import megabooks.megabooks.domain.book.dto.BookResponseDTO;

public interface BookRepositoryCustom {
    BookResponseDTO.BookFindOneDTO findOne(Long bookId);
    BookResponseDTO.BookFindAllDTO findAllBook();
}
