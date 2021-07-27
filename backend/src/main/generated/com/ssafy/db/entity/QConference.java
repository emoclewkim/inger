package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QConference is a Querydsl query type for Conference
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QConference extends EntityPathBase<Conference> {

    private static final long serialVersionUID = -625543586L;

    public static final QConference conference = new QConference("conference");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> category = createNumber("category", Integer.class);

    public final DatePath<java.sql.Date> end_room_date = createDate("end_room_date", java.sql.Date.class);

    public final TimePath<java.sql.Time> end_room_time = createTime("end_room_time", java.sql.Time.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Integer> max_people = createNumber("max_people", Integer.class);

    public final NumberPath<Integer> now_people = createNumber("now_people", Integer.class);

    public final StringPath session = createString("session");

    public final DatePath<java.sql.Date> start_room_date = createDate("start_room_date", java.sql.Date.class);

    public final TimePath<java.sql.Time> start_room_time = createTime("start_room_time", java.sql.Time.class);

    public QConference(String variable) {
        super(Conference.class, forVariable(variable));
    }

    public QConference(Path<? extends Conference> path) {
        super(path.getType(), path.getMetadata());
    }

    public QConference(PathMetadata metadata) {
        super(Conference.class, metadata);
    }

}

