package megabooks.megabooks.domain.like.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.book.service.BookService;
import megabooks.megabooks.domain.like.entity.Likes;
import megabooks.megabooks.domain.like.mapper.LikesMapper;
import megabooks.megabooks.domain.like.repository.LikesRepository;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.domain.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class LikesServiceImpl implements LikesService {
    private final LikesRepository likesRepository;
    private final UserService userService;
    private final BookService bookService;
    private final LikesMapper likesMapper;
    @Override
    public Page<BookResponseDTO.BookFindOneDTO> findLikesAllByUserId(Long userId, Pageable pageable) {
        return likesRepository.findLikesAllByUserIdWithPageable(userId, pageable);
    }

    @Override
    public void toggle(Long bookId, Long userId) {
        User findUser = userService.getUser_Id(userId);
        Book findBook = bookService.getBook_id(bookId);

        checkLikes(findUser, findBook);
    }

    private void checkLikes(User findUser, Book findBook) {
        Optional<Likes> optionalLikes = likesRepository.findByUserAndBook(findUser, findBook);
        if(optionalLikes.isPresent()) {
            likesRepository.delete(optionalLikes.get());
            findBook.minusLikes();
        } else {
            likesRepository.save(likesMapper.toLikesEntity(findUser, findBook));
            findBook.plusLikes();
        }
    }
}
