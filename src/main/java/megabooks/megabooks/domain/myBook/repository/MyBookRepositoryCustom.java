package megabooks.megabooks.domain.myBook.repository;

import megabooks.megabooks.domain.myBook.dto.MyBookResponseDTO;

public interface MyBookRepositoryCustom {
    MyBookResponseDTO.MyBookFindAll findAll(String userEmail);
}
