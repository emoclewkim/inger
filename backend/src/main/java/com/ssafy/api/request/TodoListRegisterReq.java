package com.ssafy.api.request;

import java.sql.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * todoList API ([POST] /api/v1/todoList/create) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ApiModel("TodoListRegisterReq")
public class TodoListRegisterReq {
	Long userId;
	Date date;
	Integer todoindex;
	String todo;
	List<TodoListDetailRegisterReq> detail;
}
