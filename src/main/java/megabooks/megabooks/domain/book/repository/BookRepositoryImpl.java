package megabooks.megabooks.domain.book.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import megabooks.megabooks.domain.user.dto.UserResponseDTO;
import megabooks.megabooks.global.common.exception.CustomException;
import megabooks.megabooks.global.common.reponse.ErrorCode;

import java.util.List;
import java.util.Optional;

import static megabooks.megabooks.domain.book.entity.QBook.book;
import static megabooks.megabooks.domain.user.entity.QUser.user;

@Slf4j
public class BookRepositoryImpl implements BookRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    public BookRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
    @Override
    public BookResponseDTO.BookFindOneDTO findOne(Long bookId) {
        return Optional.ofNullable(queryFactory
                        .select(Projections.constructor(BookResponseDTO.BookFindOneDTO.class,
                                book.id,
                                book.bookTitle,
                                book.bookAuthor,
                                book.bookPublisher,
                                book.bookPrice,
                                book.bookImg,
                                book.bookGenre
                        ))
                        .from(book)
                        .where(book.id.eq(bookId))
                        .fetchOne())
                .orElseThrow(() -> new CustomException(ErrorCode.Book_NOT_FOUND));
    }

    @Override
    public BookResponseDTO.BookFindAllDTO findAllBook() {
        List<BookResponseDTO.BookFindOneDTO> books = queryFactory
                .select(Projections.constructor(BookResponseDTO.BookFindOneDTO.class,
                        book.id,
                        book.bookTitle,
                        book.bookAuthor,
                        book.bookPublisher,
                        book.bookPrice,
                        book.bookImg,
                        book.bookGenre
                ))
                .from(book)
                .fetch();

        BookResponseDTO.BookFindAllDTO result = new BookResponseDTO.BookFindAllDTO(books);
        return result;
    }
}
