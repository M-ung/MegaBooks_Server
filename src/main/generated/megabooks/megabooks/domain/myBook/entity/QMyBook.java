package megabooks.megabooks.domain.myBook.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMyBook is a Querydsl query type for MyBook
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMyBook extends EntityPathBase<MyBook> {

    private static final long serialVersionUID = -571609275L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMyBook myBook = new QMyBook("myBook");

    public final megabooks.megabooks.global.entity.QBaseEntity _super = new megabooks.megabooks.global.entity.QBaseEntity(this);

    public final megabooks.megabooks.domain.book.entity.QBook book;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final NumberPath<Long> myBookId = createNumber("myBookId", Long.class);

    public final NumberPath<Integer> myBookProcess = createNumber("myBookProcess", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedTime = _super.updatedTime;

    public final megabooks.megabooks.domain.user.entity.QUser user;

    public QMyBook(String variable) {
        this(MyBook.class, forVariable(variable), INITS);
    }

    public QMyBook(Path<? extends MyBook> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMyBook(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMyBook(PathMetadata metadata, PathInits inits) {
        this(MyBook.class, metadata, inits);
    }

    public QMyBook(Class<? extends MyBook> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.book = inits.isInitialized("book") ? new megabooks.megabooks.domain.book.entity.QBook(forProperty("book")) : null;
        this.user = inits.isInitialized("user") ? new megabooks.megabooks.domain.user.entity.QUser(forProperty("user")) : null;
    }

}

