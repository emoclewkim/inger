package com.ssafy.api.response;

import java.sql.Date;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("TimerResponse")
public class TimerRes {
	
	Long id;
	Long userid;
	Date date;
	Integer studyTime;
	
}
