package megabooks.megabooks.domain.myBook.service;

import megabooks.megabooks.domain.myBook.dto.MyBookResponseDTO;

public interface MyBookService {
    MyBookResponseDTO.MyBookFindAll findAll(String userEmail);
}
