package com.ssafy.api.response;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("CalendarResponse")
public class DetailsCodeRes {
	Long id;
	String name;
	Long type;
}
