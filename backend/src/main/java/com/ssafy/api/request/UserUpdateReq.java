package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 유저 정보 수정 API ([PATCH] /api/v1/users/modify/{kakaoIdNum}) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ApiModel("UserUpdateReq")
public class UserUpdateReq {
	@ApiModelProperty(name="유저 Category", example="101")
	Integer category;
	@ApiModelProperty(name="다짐 공개 여부", example="false")
	Boolean isOpen;
	@ApiModelProperty(name="닉네임", example="nickname")
	String name;

}