package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * todoList API ([PATCH] /api/v1/todoList/update) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ApiModel("TodoListRegisterUpdateReq")
public class TodoListRegisterUpdateReq {
	Long id;
	Integer todoindex;
	String todo;
	Boolean isFinish;
}
