package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("ConferenceRegisterReq")
public class ConferenceRegisterReq {
	
	@ApiModelProperty(name="회원 아이디", example="1")
	Long userId;
	@ApiModelProperty(name="세션 이름", example="openviduuu11")
	String session;

}
