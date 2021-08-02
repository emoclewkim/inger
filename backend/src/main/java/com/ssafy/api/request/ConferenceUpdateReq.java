package com.ssafy.api.request;

import java.sql.Date;
import java.sql.Time;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("ConferenceUpdateReq")
public class ConferenceUpdateReq {
	
	@ApiModelProperty(name="카테고리 세부코드", example="201")
	Integer category;
	@ApiModelProperty(name="openvidu 세션", example="OPENVIDUSESSION")
	String session;
	@ApiModelProperty(name="공부중인 인원", example="2")
	Integer nowPeople;
	@ApiModelProperty(name="최대 인원", example="6")
	Integer maxPeople;
	@ApiModelProperty(name="공부방 시작 날짜", example="2021-07-01")
	Date startRoomDate;
	@ApiModelProperty(name="공부방 시작 시간", example="18:31")
	Time startRoomTime;
	@ApiModelProperty(name="공부방 종료 날짜", example="2021-07-01")
	Date endRoomDate;
	@ApiModelProperty(name="공부방 종료 시간", example="11:23")
	Time endRoomTime;
}
