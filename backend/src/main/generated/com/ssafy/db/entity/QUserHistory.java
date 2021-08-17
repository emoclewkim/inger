package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserHistory is a Querydsl query type for UserHistory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserHistory extends EntityPathBase<UserHistory> {

    private static final long serialVersionUID = 1625308487L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserHistory userHistory = new QUserHistory("userHistory");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QConference conference;

    public final DatePath<java.sql.Date> enterDate = createDate("enterDate", java.sql.Date.class);

    public final TimePath<java.sql.Time> enterTime = createTime("enterTime", java.sql.Time.class);

    public final DatePath<java.sql.Date> exitDate = createDate("exitDate", java.sql.Date.class);

    public final TimePath<java.sql.Time> exitTime = createTime("exitTime", java.sql.Time.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public final QUser user;

    public QUserHistory(String variable) {
        this(UserHistory.class, forVariable(variable), INITS);
    }

    public QUserHistory(Path<? extends UserHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserHistory(PathMetadata metadata, PathInits inits) {
        this(UserHistory.class, metadata, inits);
    }

    public QUserHistory(Class<? extends UserHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.conference = inits.isInitialized("conference") ? new QConference(forProperty("conference")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

