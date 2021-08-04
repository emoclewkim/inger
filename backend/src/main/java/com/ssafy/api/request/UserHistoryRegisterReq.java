package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("UserHistoryRegisterReq")
public class UserHistoryRegisterReq {
	@ApiModelProperty(name="회원 번호", example="1")
	Long userId;
	@ApiModelProperty(name="공부방 번호", example="1")
	Long conferenceId;
	@ApiModelProperty(name="시간 세부 코드", example="301")
	Integer type;
	
}
