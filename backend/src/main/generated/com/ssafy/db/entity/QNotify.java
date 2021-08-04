package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNotify is a Querydsl query type for Notify
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QNotify extends EntityPathBase<Notify> {

    private static final long serialVersionUID = 1574844811L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNotify notify = new QNotify("notify");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> handling = createNumber("handling", Integer.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final DatePath<java.sql.Date> notifyDate = createDate("notifyDate", java.sql.Date.class);

    public final StringPath reason = createString("reason");

    public final QUser user;

    public QNotify(String variable) {
        this(Notify.class, forVariable(variable), INITS);
    }

    public QNotify(Path<? extends Notify> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QNotify(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QNotify(PathMetadata metadata, PathInits inits) {
        this(Notify.class, metadata, inits);
    }

    public QNotify(Class<? extends Notify> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

