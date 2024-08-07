package megabooks.megabooks.domain.book.repository;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.*;
import static megabooks.megabooks.domain.book.entity.QBook.book;
import static megabooks.megabooks.domain.order.entity.QOrder.order;
import static megabooks.megabooks.domain.orderBook.entity.QOrderBook.orderBook;

@Slf4j
public class BookRepositoryImpl implements BookRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public BookRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    private Page<BookResponseDTO.BookFindOneDTO> findAllByBestWithPageable(Pageable pageable, LocalDateTime date) {
        List<BookResponseDTO.BookFindOneDTO> results = queryFactory.select(Projections.constructor(BookResponseDTO.BookFindOneDTO.class,
                        book.bookId,
                        book.bookTitle,
                        book.bookAuthor,
                        book.bookPublisher,
                        book.bookImgUrl,
                        book.bookGenre,
                        book.stars
                ))
                .from(orderBook)
                .join(orderBook.book, book)
                .join(orderBook.order, order)
                .where(order.orderDate.after(date))
                .groupBy(book.bookId)
                .orderBy(orderBook.totalPrice.sum().desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory
                .selectFrom(orderBook)
                .join(orderBook.book, book)
                .join(orderBook.order, order)
                .where(order.orderDate.after(date))
                .groupBy(book.bookId)
                .fetchCount();

        return new PageImpl<>(results, pageable, total);
    }

    @Override
    public Page<BookResponseDTO.BookFindOneDTO> findAllByMonthlyBestWithPageable(Pageable pageable) {
        LocalDateTime oneMonthAgo = LocalDateTime.now().minusDays(30);
        return findAllByBestWithPageable(pageable, oneMonthAgo);
    }

    @Override
    public Page<BookResponseDTO.BookFindOneDTO> findAllByWeeklyBestWithPageable(Pageable pageable) {
        LocalDateTime oneWeekAgo = LocalDateTime.now().minusDays(7);
        return findAllByBestWithPageable(pageable, oneWeekAgo);
    }

    @Override
    public BookResponseDTO.BookFindDetailDTO findDetailByBookId(Long bookId) {
        return queryFactory.select(Projections.constructor(BookResponseDTO.BookFindDetailDTO.class,
                        book.bookId,
                        book.bookTitle,
                        book.bookSummary,
                        book.bookStatus,
                        book.bookAuthor,
                        book.bookPublisher,
                        book.bookImgUrl,
                        book.bookGenre,
                        book.bookDate,
                        book.stars,
                        book.downloads
                ))
                .from(book)
                .where(book.bookId.eq(bookId))
                .fetchOne();
    }

    @Override
    public Page<BookResponseDTO.BookFindOneDTO> findAllByKeywordWithPageable(String keyword, Pageable pageable) {
        List<BookResponseDTO.BookFindOneDTO> results = queryFactory.select(Projections.constructor(BookResponseDTO.BookFindOneDTO.class,
                        book.bookId,
                        book.bookTitle,
                        book.bookAuthor,
                        book.bookPublisher,
                        book.bookImgUrl,
                        book.bookGenre,
                        book.stars
                ))
                .from(book)
                .where(bookTitleContains(keyword)
                        .or(bookAuthorContains(keyword))
                        .or(bookPublisherContains(keyword)))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory
                .selectFrom(book)
                .where(bookTitleContains(keyword)
                        .or(bookAuthorContains(keyword))
                        .or(bookPublisherContains(keyword)))
                .fetchCount();

        return new PageImpl<>(results, pageable, total);
    }

    private BooleanExpression bookTitleContains(String keyword) {
        return keyword != null ? book.bookTitle.containsIgnoreCase(keyword) : null;
    }

    private BooleanExpression bookAuthorContains(String keyword) {
        return keyword != null ? book.bookAuthor.containsIgnoreCase(keyword) : null;
    }

    private BooleanExpression bookPublisherContains(String keyword) {
        return keyword != null ? book.bookPublisher.containsIgnoreCase(keyword) : null;
    }

}