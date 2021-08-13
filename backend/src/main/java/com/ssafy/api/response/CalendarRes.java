package com.ssafy.api.response;

import java.sql.Date;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("CalendarResponse")
public class CalendarRes {
	
	Long id;
	Long userid;
	Date date;
	String promise;
	String diary;
	Integer studyTime;
	
}
