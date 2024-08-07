package megabooks.megabooks.domain.myBook.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.myBook.dto.MyBookResponseDTO;
import megabooks.megabooks.domain.myBook.repository.MyBookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class MyBookServiceImpl implements MyBookService {
    private final MyBookRepository myBookRepository;

    @Override
    public Page<MyBookResponseDTO.MyBookFindOneDTO> findAllByUserId(Long userId, Pageable pageable) {
        return myBookRepository.findAllByUserIdWithPageable(userId, pageable);
    }
}
