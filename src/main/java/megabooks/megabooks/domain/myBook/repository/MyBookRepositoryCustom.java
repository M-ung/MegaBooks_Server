package megabooks.megabooks.domain.myBook.repository;

import megabooks.megabooks.domain.myBook.dto.MyBookResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MyBookRepositoryCustom {
    Page<MyBookResponseDTO.MyBookFindOneDTO> findAllByUserIdWithPageable(Long userId, Pageable pageable);
}
