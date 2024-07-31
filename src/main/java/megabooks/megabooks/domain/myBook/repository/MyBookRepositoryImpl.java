package megabooks.megabooks.domain.myBook.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.myBook.dto.MyBookResponseDTO;

import java.util.List;

import static megabooks.megabooks.domain.Image.entity.QImage.image;
import static megabooks.megabooks.domain.book.entity.QBook.book;
import static megabooks.megabooks.domain.myBook.entity.QMyBook.myBook;

@Slf4j
public class MyBookRepositoryImpl implements MyBookRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public MyBookRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
    @Override
    public MyBookResponseDTO.MyBookFindAll findAll(String userEmail) {
        return null;
    }
}
