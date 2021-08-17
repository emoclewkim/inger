package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTodoListDetail is a Querydsl query type for TodoListDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTodoListDetail extends EntityPathBase<TodoListDetail> {

    private static final long serialVersionUID = -1279349833L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTodoListDetail todoListDetail = new QTodoListDetail("todoListDetail");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath detail = createString("detail");

    public final NumberPath<Integer> detailindex = createNumber("detailindex", Integer.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final BooleanPath isFinish = createBoolean("isFinish");

    public final QTodoList todoList;

    public QTodoListDetail(String variable) {
        this(TodoListDetail.class, forVariable(variable), INITS);
    }

    public QTodoListDetail(Path<? extends TodoListDetail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTodoListDetail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTodoListDetail(PathMetadata metadata, PathInits inits) {
        this(TodoListDetail.class, metadata, inits);
    }

    public QTodoListDetail(Class<? extends TodoListDetail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.todoList = inits.isInitialized("todoList") ? new QTodoList(forProperty("todoList"), inits.get("todoList")) : null;
    }

}

