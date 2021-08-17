package com.ssafy.api.request;

import java.sql.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 캘린더 ([POST] /api/v1/calendar) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ApiModel("CalendarRegisterReq")
public class CalendarRegisterReq {
	
	@ApiModelProperty(name="회원 번호", example="1")
	Long userId;
	@ApiModelProperty(name="날짜", example="2021-07-27")
	Date date;
	@ApiModelProperty(name="오늘의 다짐", example="할 수 있다!!!! 가즈아!!!")
	String promise;
	@ApiModelProperty(name="오늘의 일기", example="공부하느라 수고했다. 화이팅!")
	String diary;
	
}
