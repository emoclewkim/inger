package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCommon_code is a Querydsl query type for Common_code
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCommon_code extends EntityPathBase<Common_code> {

    private static final long serialVersionUID = -925028673L;

    public static final QCommon_code common_code = new QCommon_code("common_code");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath kind = createString("kind");

    public QCommon_code(String variable) {
        super(Common_code.class, forVariable(variable));
    }

    public QCommon_code(Path<? extends Common_code> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommon_code(PathMetadata metadata) {
        super(Common_code.class, metadata);
    }

}

