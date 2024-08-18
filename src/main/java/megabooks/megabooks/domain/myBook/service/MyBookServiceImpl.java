package megabooks.megabooks.domain.myBook.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.myBook.dto.MyBookResponseDTO;
import megabooks.megabooks.domain.myBook.entity.MyBook;
import megabooks.megabooks.domain.myBook.mapper.MyBookMapper;
import megabooks.megabooks.domain.myBook.repository.MyBookRepository;
import megabooks.megabooks.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class MyBookServiceImpl implements MyBookService {
    private final MyBookRepository myBookRepository;
    private final MyBookMapper myBookMapper;

    @Override
    public List<MyBookResponseDTO.MyBookFindOneDTO> findAllByUserId(Long userId, Pageable pageable) {
        return myBookRepository.findAllByUserIdWithPageable(userId, pageable);
    }

    @Override
    public void create(User user, Book book) {
        myBookRepository.save(myBookMapper.toMyBookEntity(user,book));
    }
}
