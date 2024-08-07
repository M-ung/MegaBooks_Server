package megabooks.megabooks.domain.myBook.service;

import megabooks.megabooks.domain.myBook.dto.MyBookResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MyBookService {
    Page<MyBookResponseDTO.MyBookFindOneDTO> findAllByUserId(Long userId, Pageable pageable);
}
