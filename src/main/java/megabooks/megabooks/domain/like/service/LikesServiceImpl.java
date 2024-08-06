package megabooks.megabooks.domain.like.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import megabooks.megabooks.domain.like.repository.LikesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class LikesServiceImpl implements LikesService {
    private final LikesRepository likesRepository;
    @Override
    public Page<BookResponseDTO.BookFindOneDTO> findLikesAllByUserId(Long userId, Pageable pageable) {
        return likesRepository.findLikesAllByUserIdWithPageable(userId, pageable);
    }
}
