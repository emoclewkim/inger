package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 유저 회원가입 API ([POST] /api/v1/users) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ApiModel("UserRegisterPostRequest")
public class UserRegisterPostReq {
	@ApiModelProperty(name="카카오 API 서비스 연결 아이디", example="1810000000")
	String kakaoIdNum;
	@ApiModelProperty(name="유저 Name", example="your_name")
	String name;
	@ApiModelProperty(name="프로필 공개 여부", example="false")
	Boolean isOpen;
	@ApiModelProperty(name="카테고리 세부코드", example="201")
	Integer category;
}
