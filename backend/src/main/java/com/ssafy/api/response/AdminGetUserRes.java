package com.ssafy.api.response;

import com.ssafy.db.entity.User;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("UserResponse")
public class AdminGetUserRes {
	Long id;
	String name;
	Integer usercode;
	
	public static AdminGetUserRes of(User user) {
		AdminGetUserRes res = new AdminGetUserRes();
		res.setId(user.getId());
		res.setName(user.getName());
		res.setUsercode(user.getUsercode());
		return res;
	}
}
