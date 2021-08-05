package com.ssafy.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.request.UserRegisterPostReq;
import com.ssafy.api.request.UserRegisterUpdateReq;
import com.ssafy.api.response.UserRegistRes;
import com.ssafy.api.response.UserRes;
import com.ssafy.api.service.UserService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 유저 관련 API 요청 처리를 위한 컨트롤러 정의.
 */
@Api(value = "유저 API", tags = { "User" })
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/regist")
	@ApiOperation(value = "회원 가입", notes = "<strong>카카오톡으로 로그인하기</strong>를 통해 회원가입 한다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "카카오 아이디 인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<UserRegistRes> register(
			@RequestBody @ApiParam(value = "회원가입 정보", required = true) UserRegisterPostReq registerInfo) {
		if(registerInfo.getKakaoIdNum() == "") {
			return ResponseEntity.status(401).body(null);
		}
		User user = userService.createUser(registerInfo);
		UserRegistRes res = userService.selectUser(user.getId());
		if(user == null || res == null) {
			return ResponseEntity.status(404).body(null);
		}
		return ResponseEntity.status(200).body(res);
	}
	
	@GetMapping("/checkname/{name}")
	@ApiOperation(value = "닉네임 중복을 확인", notes = "<strong>닉네임 중복</strong>을 확인한다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "닉네임 이미 존재"),
			@ApiResponse(code = 404, message = "사용자 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<BaseResponseBody> checkName(@PathVariable String name) {
		Optional<User> user = userService.checkUserByName(name);
		if (!user.isPresent()) {
			return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
		} else {
			return ResponseEntity.status(401).body(BaseResponseBody.of(401, "Fail"));
		}	
	}
	
	@GetMapping("/{kakaoIdNum}")
	@ApiOperation(value = "회원 정보 조회", notes = "로그인한 회원 본인의 정보를 응답한다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<UserRegistRes> getUserInfo(@PathVariable String kakaoIdNum) {
		Optional<User> user = userService.getUserByKakaoIdNum(kakaoIdNum);
		if(!user.isPresent()) {
			return ResponseEntity.status(200).body(null);
		}
		UserRegistRes res = userService.selectUser(user.get().getId());
		if (res == null) {
			return ResponseEntity.status(404).body(null);
		}
		return ResponseEntity.status(200).body(res);
	}
	
	@GetMapping("/view/{kakaoIdNum}")
	@ApiOperation(value = "타인 정보 조회", notes = "타인 프로필을 열람한다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<UserRes> getOtherUserInfo(@PathVariable String kakaoIdNum) {
		Optional<User> user = userService.getUserByKakaoIdNum(kakaoIdNum);
		System.out.println(user.get().getIsOpen());
		if(user.get().getIsOpen() == false) { // 프로필 비공개
			return ResponseEntity.status(200).body(null);			
		}
		return ResponseEntity.status(200).body(UserRes.of(user.get()));
	}

	@PatchMapping("/modify/{kakaoIdNum}")
	@ApiOperation(value = "회원 본인 정보 수정", notes = "로그인한 회원 본인의 정보를 수정한다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<UserRegistRes> modifyUser(@PathVariable String kakaoIdNum,
			@RequestBody UserRegisterUpdateReq registerInfo) {
		User user = userService.updateUserByKakaoIdNum(kakaoIdNum, registerInfo);
		UserRegistRes res = userService.selectUser(user.getId());
		if (user == null || res == null) {
			return ResponseEntity.status(401).body(null);
		}
		return ResponseEntity.status(200).body(res);
	}

	@DeleteMapping("/{kakaoIdNum}")
		@ApiOperation(value = "회원 본인 정보 삭제", notes = "로그인한 회원 본인의 정보를 삭제한다.")
		@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
				@ApiResponse(code = 404, message = "사용자 없음"), @ApiResponse(code = 500, message = "서버 오류") })	
	public ResponseEntity<BaseResponseBody> deleteUser(@PathVariable String kakaoIdNum) {
		Optional<User> user = userService.getUserByKakaoIdNum(kakaoIdNum);
		if(!user.isPresent()) {
			return ResponseEntity.status(404).body(null);
		}
		userService.deleteUserByKakaoIdNum(kakaoIdNum);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
}
