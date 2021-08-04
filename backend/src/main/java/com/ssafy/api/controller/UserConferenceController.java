package com.ssafy.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.request.UserConferenceRegisterReq;
import com.ssafy.api.service.UserConferenceService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.BaseEntity;
import com.ssafy.db.entity.UserConference;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value= "실시간 공부방인원 API", tags= {"UserConference"})
@RestController
@RequestMapping("/api/v1/userconference")
public class UserConferenceController {
	@Autowired
	UserConferenceService userConferenceService;
	
	@PostMapping("/regist")
	@ApiOperation(value="실시간 공부방회원 인원 등록", notes="")
	public ResponseEntity<? extends BaseResponseBody> registerUserConference(@RequestBody UserConferenceRegisterReq registerInfo){
		Optional<UserConference> userconference = userConferenceService.createUserConference(registerInfo);
		if(userconference!=null) {			
			return ResponseEntity.status(200).body(BaseResponseBody.of(200,"Success"));
		}else {
			return ResponseEntity.status(500).body(BaseResponseBody.of(500,"Fail"));
		}
	}
	
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value="실시간 공부방회원 인원 삭제",notes="")
	public ResponseEntity<? extends BaseResponseBody> deleteUserConference(@PathVariable Long id){
		userConferenceService.deleteUserConference(id);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	
	
}
