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

    public final megabooks.megabooks.global.common.QBaseEntity _super = new megabooks.megabooks.global.common.QBaseEntity(this);

    public final StringPath bookAuthor = createString("bookAuthor");

    public final EnumPath<Genre> bookGenre = createEnum("bookGenre", Genre.class);

    public final StringPath bookImg = createString("bookImg");

    public final NumberPath<Integer> bookPrice = createNumber("bookPrice", Integer.class);

    public final StringPath bookPublisher = createString("bookPublisher");

    public final StringPath bookTitle = createString("bookTitle");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedTime = _super.updatedTime;

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

