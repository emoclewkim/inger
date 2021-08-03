package com.ssafy.api.response;


import java.sql.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("TodoListResponse")
public class TodoListRes {
	Long id;
	Long userId;
	Date date;
	Integer todoindex;
	String todo;
	Boolean isFinish;
	List<TodoListDetailRes> detail;
}
