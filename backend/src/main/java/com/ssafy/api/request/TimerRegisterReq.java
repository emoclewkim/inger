package com.ssafy.api.request;

import java.sql.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 캘린더 ([POST] /api/v1/timer) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ApiModel("TimerRegisterReq")
public class TimerRegisterReq {

	@ApiModelProperty(name="회원 번호", example="1")
	Long userId;
	@ApiModelProperty(name="날짜", example="2021-07-27")
	Date date;
	@ApiModelProperty(name="오늘의 공부 시간(초)", example="1000")
	Integer studyTime;
	
}
