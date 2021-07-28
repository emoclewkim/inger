package com.ssafy.api.response;

import java.sql.Date;

import com.ssafy.db.entity.Calendar;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 캘린더 정보 조회 API ([GET] /api/v1/calendar/list) 요청에 대한 응답값 정의.
 */
@Getter
@Setter
@ApiModel("CalendarResponse")
public class CalendarRes {
	@ApiModelProperty(name="User ID")
	Date date;
	String promise;
	String diary;
	
	public static CalendarRes of(Calendar calendar) {
		CalendarRes res = new CalendarRes();
		res.setDate(calendar.getDate());
		res.setPromise(calendar.getPromise());
		res.setDiary(calendar.getDiary());
		return res;
	}
}
