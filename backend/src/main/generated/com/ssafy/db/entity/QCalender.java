package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCalender is a Querydsl query type for Calender
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCalender extends EntityPathBase<Calender> {

    private static final long serialVersionUID = -166324868L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCalender calender = new QCalender("calender");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final DatePath<java.sql.Date> date = createDate("date", java.sql.Date.class);

    public final StringPath diary = createString("diary");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath promise = createString("promise");

    public final QUser user;

    public QCalender(String variable) {
        this(Calender.class, forVariable(variable), INITS);
    }

    public QCalender(Path<? extends Calender> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCalender(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCalender(PathMetadata metadata, PathInits inits) {
        this(Calender.class, metadata, inits);
    }

    public QCalender(Class<? extends Calender> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

