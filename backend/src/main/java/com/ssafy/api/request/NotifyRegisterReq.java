package com.ssafy.api.request;

import java.sql.Date;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("NotifyRegisterReq")
public class NotifyRegisterReq {
	Long userId;
	Date notifyDate;
	String reason;
	Integer handling;
}
