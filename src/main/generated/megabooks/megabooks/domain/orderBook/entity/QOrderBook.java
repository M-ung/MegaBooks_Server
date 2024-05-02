package megabooks.megabooks.domain.orderBook.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrderBook is a Querydsl query type for OrderBook
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrderBook extends EntityPathBase<OrderBook> {

    private static final long serialVersionUID = 460926946L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrderBook orderBook = new QOrderBook("orderBook");

    public final megabooks.megabooks.global.common.QBaseEntity _super = new megabooks.megabooks.global.common.QBaseEntity(this);

    public final megabooks.megabooks.domain.book.entity.QBook book;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> mileage = createNumber("mileage", Integer.class);

    public final megabooks.megabooks.domain.order.entity.QOrder order;

    public final NumberPath<Integer> totalPrice = createNumber("totalPrice", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedTime = _super.updatedTime;

    public QOrderBook(String variable) {
        this(OrderBook.class, forVariable(variable), INITS);
    }

    public QOrderBook(Path<? extends OrderBook> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrderBook(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrderBook(PathMetadata metadata, PathInits inits) {
        this(OrderBook.class, metadata, inits);
    }

    public QOrderBook(Class<? extends OrderBook> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.book = inits.isInitialized("book") ? new megabooks.megabooks.domain.book.entity.QBook(forProperty("book")) : null;
        this.order = inits.isInitialized("order") ? new megabooks.megabooks.domain.order.entity.QOrder(forProperty("order"), inits.get("order")) : null;
    }

}

