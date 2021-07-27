package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QtodoListDetail is a Querydsl query type for todoListDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QtodoListDetail extends EntityPathBase<todoListDetail> {

    private static final long serialVersionUID = -277356649L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QtodoListDetail todoListDetail = new QtodoListDetail("todoListDetail");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath detail = createString("detail");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final BooleanPath isFinish = createBoolean("isFinish");

    public final QTodoList todoList;

    public QtodoListDetail(String variable) {
        this(todoListDetail.class, forVariable(variable), INITS);
    }

    public QtodoListDetail(Path<? extends todoListDetail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QtodoListDetail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QtodoListDetail(PathMetadata metadata, PathInits inits) {
        this(todoListDetail.class, metadata, inits);
    }

    public QtodoListDetail(Class<? extends todoListDetail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.todoList = inits.isInitialized("todoList") ? new QTodoList(forProperty("todoList"), inits.get("todoList")) : null;
    }

}

