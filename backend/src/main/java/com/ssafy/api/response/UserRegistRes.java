package com.ssafy.api.response;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * 회원 본인 정보 조회 API ([POST] /api/v1/users/regist) 요청에 대한 응답값 정의.
 */
@Getter
@Setter
@ApiModel("UserRegistResponse")
public class UserRegistRes {
	String message;
	Long id;
	String kakaoIdNum;
	String name;
	Boolean isOpen;
	Integer usercode;
	Integer category;
}
