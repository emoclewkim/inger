package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTodolist is a Querydsl query type for Todolist
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTodolist extends EntityPathBase<Todolist> {

    private static final long serialVersionUID = -1283022938L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTodolist todolist = new QTodolist("todolist");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final DatePath<java.sql.Date> date = createDate("date", java.sql.Date.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final BooleanPath is_finish = createBoolean("is_finish");

    public final StringPath todo = createString("todo");

    public final NumberPath<Integer> todoindex = createNumber("todoindex", Integer.class);

    public final QUser user;

    public QTodolist(String variable) {
        this(Todolist.class, forVariable(variable), INITS);
    }

    public QTodolist(Path<? extends Todolist> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTodolist(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTodolist(PathMetadata metadata, PathInits inits) {
        this(Todolist.class, metadata, inits);
    }

    public QTodolist(Class<? extends Todolist> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

