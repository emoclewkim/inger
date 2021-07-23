package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDetails_code is a Querydsl query type for Details_code
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDetails_code extends EntityPathBase<Details_code> {

    private static final long serialVersionUID = -1926760820L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDetails_code details_code = new QDetails_code("details_code");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QCommon_code commonCode;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public QDetails_code(String variable) {
        this(Details_code.class, forVariable(variable), INITS);
    }

    public QDetails_code(Path<? extends Details_code> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDetails_code(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDetails_code(PathMetadata metadata, PathInits inits) {
        this(Details_code.class, metadata, inits);
    }

    public QDetails_code(Class<? extends Details_code> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.commonCode = inits.isInitialized("commonCode") ? new QCommon_code(forProperty("commonCode")) : null;
    }

}

