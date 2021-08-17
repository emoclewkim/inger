package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * todoListDetail API ([POST] /api/v1/todoList/createDetail) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ApiModel("TodoListDetailRegisterReq")
public class TodoListDetailRegisterReq {
	Long todoId;
	Integer detailindex;
	String detail;
}
