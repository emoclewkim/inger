package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * todoListDetail API ([POST] /api/v1/todoList/updateDetail) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ApiModel("TodoListDetailRegisterUpdateReq")
public class TodoListDetailRegisterUpdateReq {
	@ApiModelProperty(name = "todoListDetail id")
	Long id;
	@ApiModelProperty(name = "번호")
	Integer detailindex;
	@ApiModelProperty(name = "상세정보")
	String detail;
	@ApiModelProperty(name = "완료 여부")
	Boolean isFinish;
}
