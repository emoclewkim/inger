package com.ssafy.api.response;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("TodoListDetailResponse")
public class TodoListDetailRes {
	Long id;
	Integer detailindex;
	String detail;
	Boolean isFinish;
}
