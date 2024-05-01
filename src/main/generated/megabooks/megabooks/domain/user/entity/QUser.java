package megabooks.megabooks.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1136350193L;

    public static final QUser user = new QUser("user");

    public final megabooks.megabooks.global.common.QBaseEntity _super = new megabooks.megabooks.global.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath role = createString("role");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedTime = _super.updatedTime;

    public final StringPath userEmail = createString("userEmail");

    public final StringPath userImg = createString("userImg");

    public final NumberPath<Integer> userMileage = createNumber("userMileage", Integer.class);

    public final StringPath userName = createString("userName");

    public final StringPath userPassword = createString("userPassword");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

