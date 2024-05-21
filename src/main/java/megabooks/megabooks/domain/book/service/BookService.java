package megabooks.megabooks.domain.book.service;

import megabooks.megabooks.domain.book.dto.BookRequestDTO;
import megabooks.megabooks.domain.book.dto.BookResponseDTO;

public interface BookService {
    // 책 업로드
    BookResponseDTO.BookUploadDTO upload(BookRequestDTO.BookUploadDTO bookUploadDTO);
    // 책 한 권 조회
    BookResponseDTO.BookFindOneDTO findOne(Long BookId);
    // 책 전체 조회
    BookResponseDTO.BookFindAllDTO findAllBook();
}
