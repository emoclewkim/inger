package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 유저 관리자 권한 수정 API ([PATCH] /api/v1/admin/{kakao_idnum}) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ApiModel("AdminRegisterUpdateReq")
public class AdminRegisterUpdateReq {
	@ApiModelProperty(name="유저 kakaoIdNum")
	Long id;
	@ApiModelProperty(name="유저 관련 세부 코드")
	Integer usercode;
}
