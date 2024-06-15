package megabooks.megabooks.domain.book.repository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import megabooks.megabooks.global.common.exception.CustomException;
import megabooks.megabooks.global.common.reponse.ErrorCode;

import java.util.*;
import static megabooks.megabooks.domain.Image.entity.QImage.image;
import static megabooks.megabooks.domain.book.entity.QBook.book;

@Slf4j
public class BookRepositoryImpl implements BookRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    public BookRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
    @Override
    public BookResponseDTO.BookFindOneDTO findOne(Long bookId) {
        BookResponseDTO.BookFindOneDTO result = queryFactory.select(Projections.constructor(BookResponseDTO.BookFindOneDTO.class,
                        book.id,
                        book.bookTitle,
                        book.bookAuthor,
                        book.bookPublisher,
                        book.bookPrice,
                        book.bookRate,
                        book.bookSales,
                        book.bookGenre
                ))
                .from(book)
                .where(book.id.eq(bookId))
                .fetchOne();

        if (result == null) {
            throw new CustomException(ErrorCode.BOOK_NOT_FOUND);
        }

        List<String> bookUrlList = queryFactory.select(image.imageUrl)
                .from(image)
                .where(image.book.id.eq(result.getId()))
                .fetch();

        result.setBookUrlList(bookUrlList);

        return result;
    }

    @Override
    public BookResponseDTO.BookFindAllDTO findAllBook() {
        List<BookResponseDTO.BookFindOneDTO> bookList = queryFactory.select(Projections.constructor(BookResponseDTO.BookFindOneDTO.class,
                        book.id,
                        book.bookTitle,
                        book.bookAuthor,
                        book.bookPublisher,
                        book.bookPrice,
                        book.bookRate,
                        book.bookSales,
                        book.bookGenre
                ))
                .from(book)
                .fetch();

        for (BookResponseDTO.BookFindOneDTO bookDTO : bookList) {
            List<String> bookUrlList = queryFactory.select(image.imageUrl)
                    .from(image)
                    .where(image.book.id.eq(bookDTO.getId()))
                    .fetch();
            bookDTO.setBookUrlList(bookUrlList);
        }

        return new BookResponseDTO.BookFindAllDTO(bookList);
    }
}
