package megabooks.megabooks.domain.myBook.repository;

import megabooks.megabooks.domain.myBook.dto.MyBookResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MyBookRepositoryCustom {
    List<MyBookResponseDTO.MyBookFindOneDTO> findAllByUserIdWithPageable(Long userId, Pageable pageable);
}
