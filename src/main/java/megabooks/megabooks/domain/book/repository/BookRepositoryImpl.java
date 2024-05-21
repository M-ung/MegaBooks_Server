package megabooks.megabooks.domain.book.repository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import megabooks.megabooks.domain.book.entity.Book;
import java.util.List;
import java.util.stream.Collectors;

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
        List<String> imageUrlList = queryFactory
                .select(image.imageUrl)
                .from(image)
                .where(image.book.id.eq(bookId))
                .fetch();

        Book findBook = queryFactory
                .selectFrom(book)
                .where(book.id.eq(bookId))
                .fetchOne();

        return new BookResponseDTO.BookFindOneDTO(findBook, imageUrlList);
    }

    @Override
    public BookResponseDTO.BookFindAllDTO findAllBook() {
        // 여기 채워줘
        List<Book> bookList = queryFactory
                .selectFrom(book)
                .fetch();

        List<BookResponseDTO.BookFindOneDTO> bookFindOneList = bookList.stream().map(b -> {
            List<String> imageUrlList = queryFactory
                    .select(image.imageUrl)
                    .from(image)
                    .where(image.book.id.eq(b.getId()))
                    .fetch();

            return new BookResponseDTO.BookFindOneDTO(b, imageUrlList);
        }).collect(Collectors.toList());

        return new BookResponseDTO.BookFindAllDTO(bookFindOneList);
    }
}
