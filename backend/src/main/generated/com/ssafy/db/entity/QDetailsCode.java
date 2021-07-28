package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDetailsCode is a Querydsl query type for DetailsCode
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDetailsCode extends EntityPathBase<DetailsCode> {

    private static final long serialVersionUID = -1032807859L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDetailsCode detailsCode = new QDetailsCode("detailsCode");

    public final QCommonCode commonCode;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QDetailsCode(String variable) {
        this(DetailsCode.class, forVariable(variable), INITS);
    }

    public QDetailsCode(Path<? extends DetailsCode> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDetailsCode(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDetailsCode(PathMetadata metadata, PathInits inits) {
        this(DetailsCode.class, metadata, inits);
    }

    public QDetailsCode(Class<? extends DetailsCode> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.commonCode = inits.isInitialized("commonCode") ? new QCommonCode(forProperty("commonCode")) : null;
    }

}

