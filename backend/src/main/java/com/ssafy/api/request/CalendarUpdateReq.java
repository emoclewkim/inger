package com.ssafy.api.request;

import java.sql.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


/**
 * 유저 정보 수정 API ([PATCH] /api/v1/calendar/{userId}) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ApiModel("CalendarUpdateReq")
public class CalendarUpdateReq {
	
	@ApiModelProperty(name="회원 번호", example="1")
	Long userId;
	@ApiModelProperty(name="날짜", example="2021-07-25")
	Date date;
	@ApiModelProperty(name="오늘의 다짐", example="힘들 때 웃는 자가 일류다!")
	String promise;
	@ApiModelProperty(name="오늘의 일기", example="오늘 공부는 정말 재미있었다.")
	String diary;
}
