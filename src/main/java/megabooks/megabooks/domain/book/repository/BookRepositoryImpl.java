package megabooks.megabooks.domain.book.repository;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.book.dto.BookResponseDTO;
import megabooks.megabooks.global.common.exception.CustomException;
import megabooks.megabooks.global.common.reponse.ErrorCode;

import java.util.*;
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
        List<Tuple> result = queryFactory
                .select(book, image.imageUrl)
                .from(book)
                .leftJoin(image).on(image.book.id.eq(bookId))
                .where(book.id.eq(bookId))
                .fetch();

        BookResponseDTO.BookDetailDTO bookDetail = result.stream()
                .findFirst()
                .map(tuple -> new BookResponseDTO.BookDetailDTO(tuple.get(book)))
                .orElseThrow(() -> new CustomException(ErrorCode.BOOK_NOT_FOUND));

        List<String> imageUrlList = result.stream()
                .map(tuple -> tuple.get(image.imageUrl))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return new BookResponseDTO.BookFindOneDTO(bookDetail, imageUrlList);
    }

    @Override
    public BookResponseDTO.BookFindAllDTO findAllBook() {
        List<Tuple> result = queryFactory
                .select(book, image.imageUrl)
                .from(book)
                .leftJoin(image).on(image.book.id.eq(book.id))
                .orderBy(book.id.asc())
                .fetch();

        Map<Long, BookResponseDTO.BookFindOneDTO> bookMap = new LinkedHashMap<>();

        for (Tuple tuple : result) {
            BookResponseDTO.BookDetailDTO bookDetail = new BookResponseDTO.BookDetailDTO(tuple.get(book));
            String imageUrl = tuple.get(image.imageUrl);
            Long bookId = bookDetail.getId();

            BookResponseDTO.BookFindOneDTO bookFindOneDTO = bookMap.computeIfAbsent(bookId, id ->
                    new BookResponseDTO.BookFindOneDTO(bookDetail, new ArrayList<>())
            );

            Optional.ofNullable(imageUrl).ifPresent(url -> bookFindOneDTO.getBookUrlList().add(url));
        }

        List<BookResponseDTO.BookFindOneDTO> bookList = new ArrayList<>(bookMap.values());
        return new BookResponseDTO.BookFindAllDTO(bookList);
    }

}
