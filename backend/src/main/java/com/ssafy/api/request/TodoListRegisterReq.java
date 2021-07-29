package com.ssafy.api.request;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * todoList API ([POST] /api/v1/todoList/create) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ApiModel("TodoListRegisterReq")
public class TodoListRegisterReq {
	@ApiModelProperty(name = "유저 id")
	Long userId;
	@ApiModelProperty(name = "todoList 날짜")
	Date date;
	@ApiModelProperty(name = "todoList 번호")
	Integer todoindex;
	@ApiModelProperty(name = "할 일")
	String todo;

}
