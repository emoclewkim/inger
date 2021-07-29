package com.ssafy.api.request;

import java.util.Date;

import com.ssafy.db.entity.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * todoListDetail API ([POST] /api/v1/todoList/createDetail) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ApiModel("TodoListDetailRegisterReq")
public class TodoListDetailRegisterReq {
	@ApiModelProperty(name = "todoList id")
	Long todoId;
	@ApiModelProperty(name = "번호")
	Integer detailindex;
	@ApiModelProperty(name = "상세정보")
	String detail;
}
