package megabooks.megabooks.domain.book.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBook is a Querydsl query type for Book
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBook extends EntityPathBase<Book> {

    private static final long serialVersionUID = 1803957549L;

    public static final QBook book = new QBook("book");

    public final StringPath bookAuthor = createString("bookAuthor");

    public final DatePath<java.time.LocalDate> bookDate = createDate("bookDate", java.time.LocalDate.class);

    public final EnumPath<BookGenre> bookGenre = createEnum("bookGenre", BookGenre.class);

    public final NumberPath<Long> bookId = createNumber("bookId", Long.class);

    public final StringPath bookImgUrl = createString("bookImgUrl");

    public final NumberPath<Integer> bookPrice = createNumber("bookPrice", Integer.class);

    public final StringPath bookPublisher = createString("bookPublisher");

    public final EnumPath<BookStatus> bookStatus = createEnum("bookStatus", BookStatus.class);

    public final StringPath bookSummary = createString("bookSummary");

    public final StringPath bookTitle = createString("bookTitle");

    public final NumberPath<Integer> downloads = createNumber("downloads", Integer.class);

    public final NumberPath<Integer> likes = createNumber("likes", Integer.class);

    public final NumberPath<Double> stars = createNumber("stars", Double.class);

    public final NumberPath<Integer> totalPage = createNumber("totalPage", Integer.class);

    public QBook(String variable) {
        super(Book.class, forVariable(variable));
    }

    public QBook(Path<? extends Book> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBook(PathMetadata metadata) {
        super(Book.class, metadata);
    }

}

