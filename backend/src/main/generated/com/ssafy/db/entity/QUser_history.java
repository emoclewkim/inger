package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser_history is a Querydsl query type for User_history
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser_history extends EntityPathBase<User_history> {

    private static final long serialVersionUID = -899685150L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser_history user_history = new QUser_history("user_history");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QConference conference;

    public final DatePath<java.sql.Date> enter_date = createDate("enter_date", java.sql.Date.class);

    public final TimePath<java.sql.Time> enter_time = createTime("enter_time", java.sql.Time.class);

    public final DatePath<java.sql.Date> exit_date = createDate("exit_date", java.sql.Date.class);

    public final TimePath<java.sql.Time> exit_time = createTime("exit_time", java.sql.Time.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public final QUser user;

    public QUser_history(String variable) {
        this(User_history.class, forVariable(variable), INITS);
    }

    public QUser_history(Path<? extends User_history> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser_history(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser_history(PathMetadata metadata, PathInits inits) {
        this(User_history.class, metadata, inits);
    }

    public QUser_history(Class<? extends User_history> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.conference = inits.isInitialized("conference") ? new QConference(forProperty("conference")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

