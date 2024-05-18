package megabooks.megabooks.domain.book.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import megabooks.megabooks.domain.book.entity.Book;
import megabooks.megabooks.domain.book.repository.BookRepository;
import megabooks.megabooks.global.common.CommonMethod;
import megabooks.megabooks.global.common.exception.CustomException;
import megabooks.megabooks.global.common.reponse.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CommonMethod commonMethod;

    @Override
    public BookResponseDTO.BookFindOneDTO findOne(Long bookId) {
        try {
            log.info("[BookServiceImpl] findOne");
            return bookRepository.findOne(bookId);
        } catch (CustomException ce){
            log.info("[CustomException] BookServiceImpl findOne");
            throw ce;
        } catch (Exception e) {
            log.info("[Exception500] BookServiceImpl findOne");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] BookServiceImpl findOne : " + e.getMessage());
        }
    }

    @Override
    public BookResponseDTO.BookFindAllDTO findAll() {
        try {
            log.info("[BookServiceImpl] findAll");
            return bookRepository.findAll();
        } catch (CustomException ce){
            log.info("[CustomException] BookServiceImpl findAll");
            throw ce;
        } catch (Exception e) {
            log.info("[Exception500] BookServiceImpl findAll");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] BookServiceImpl findAll : " + e.getMessage());
        }
    }
}
