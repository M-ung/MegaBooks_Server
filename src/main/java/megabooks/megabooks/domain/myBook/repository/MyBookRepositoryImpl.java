package megabooks.megabooks.domain.myBook.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import megabooks.megabooks.domain.myBook.dto.MyBookResponseDTO;

import java.util.List;

import static megabooks.megabooks.domain.Image.entity.QImage.image;
import static megabooks.megabooks.domain.book.entity.QBook.book;
import static megabooks.megabooks.domain.myBook.entity.QMyBook.myBook;

public class MyBookRepositoryImpl implements MyBookRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public MyBookRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
    @Override
    public MyBookResponseDTO.MyBookFindAll findAll(String userEmail) {
        List<MyBookResponseDTO.MyBookFindOne> myBookList = queryFactory
                .select(Projections.constructor(MyBookResponseDTO.MyBookFindOne.class,
                        book.id,
                        book.bookTitle,
                        book.bookAuthor,
                        book.bookPublisher,
                        book.bookRate,
                        book.bookGenre,
                        myBook.myBookStatus
                ))
                .from(myBook)
                .join(myBook.book, book)
                .where(myBook.user.userEmail.eq(userEmail))
                .fetch();

        for (MyBookResponseDTO.MyBookFindOne myBookDTO : myBookList) {
            List<String> bookUrlList = queryFactory.select(image.imageUrl)
                    .from(image)
                    .where(image.book.id.eq(myBookDTO.getBookId()))
                    .fetch();
            myBookDTO.setBookUrlList(bookUrlList);
        }
        return new MyBookResponseDTO.MyBookFindAll(userEmail, myBookList);
    }
}
