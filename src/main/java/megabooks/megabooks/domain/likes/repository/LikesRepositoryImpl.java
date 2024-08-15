package megabooks.megabooks.domain.likes.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static megabooks.megabooks.domain.book.entity.QBook.book;
import static megabooks.megabooks.domain.likes.entity.QLikes.likes;

public class LikesRepositoryImpl implements LikesRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public LikesRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<BookResponseDTO.BookFindOneDTO> findLikesAllByUserIdWithPageable(Long userId, Pageable pageable) {
        List<BookResponseDTO.BookFindOneDTO> results = queryFactory.select(Projections.constructor(BookResponseDTO.BookFindOneDTO.class,
                        book.bookId,
                        book.bookTitle,
                        book.bookAuthor,
                        book.bookPublisher,
                        book.bookImgUrl,
                        book.bookGenre,
                        book.stars
                ))
                .from(likes)
                .join(likes.book, book)
                .where(likes.user.userId.eq(userId))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory
                .selectFrom(likes)
                .where(likes.user.userId.eq(userId))
                .fetchCount();

        return new PageImpl<>(results, pageable, total);
    }
}
