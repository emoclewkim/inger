package com.ssafy.api.response;

import java.sql.Date;
import java.sql.Time;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("UserHistoryResponse")
public class UserHistoryRes {
	Long id;
	Long userid;
	Long conferenceid;
	Integer type;
	Date enterDate;
	Time enterTime;
	Date exitDate;
	Time exitTime;
}
