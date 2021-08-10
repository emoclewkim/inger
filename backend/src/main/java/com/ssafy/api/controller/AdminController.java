package com.ssafy.api.controller;

import java.util.List;
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

import com.ssafy.api.request.AdminRegisterUpdateReq;
import com.ssafy.api.request.NotifyRegisterReq;
import com.ssafy.api.response.AdminGetUserRes;
import com.ssafy.api.response.DetailsCodeRes;
import com.ssafy.api.service.AdminService;
import com.ssafy.api.service.UserService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.CommonCode;
import com.ssafy.db.entity.DetailsCode;
import com.ssafy.db.entity.Notify;
import com.ssafy.db.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 관리자 관련 API 요청 처리를 위한 컨트롤러 정의.
 */
@Api(value = "관리자 API", tags = { "Admin" })
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

	@Autowired
	UserService userService;

	@Autowired
	AdminService adminService;

	@GetMapping("/getUserByName/{name}")
	@ApiOperation(value = "닉네임으로 회원 조회", notes = "관리자 권한 부여를 위해 name으로 회원을 검색하고, 있으면 id, name, usercode값을 돌려줌")
	public ResponseEntity<AdminGetUserRes> getUserByName(@PathVariable String name) {
		Optional<User> user = userService.getUserByName(name);

		if (!user.isPresent()) {
			return ResponseEntity.status(200).body(null);
		}

		return ResponseEntity.status(200).body(AdminGetUserRes.of(user.get()));
	}

	@PatchMapping("/setAdmin")
	@ApiOperation(value = "회원에게 권한 부여", notes = "id값과 공통코드값을 보내면 회원에게 해당 공통코드 권한 부여")
	public ResponseEntity<BaseResponseBody> setAdmin(@RequestBody AdminRegisterUpdateReq adminRegisterUpdateReq) {
		User user = adminService.updateUserByKakaoIdnum(adminRegisterUpdateReq);

		if (user == null) {
			return ResponseEntity.status(401).body(BaseResponseBody.of(401, "Fail"));
		}

		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}

	@GetMapping("/getCommonCodeList")
	@ApiOperation(value = "commonCode조회", notes = "DB에 저장되어 있는 commonCode의 목록을 조회")
	public ResponseEntity<List<CommonCode>> getCommonCodeList() {
		List<CommonCode> list = adminService.getCommonCodeList().get();
		return ResponseEntity.status(200).body(list);

	}

	@PostMapping("/setCommonCode/{kind}")
	@ApiOperation(value = "commonCode추가", notes = "DB에 commonCode를 추가(PK가 AI설정되어 있어서 commonCode의 kind값만 받으면 됨)")
	public ResponseEntity<BaseResponseBody> setCommonCode(@PathVariable String kind) {
		CommonCode commonCode = adminService.createCommonCode(kind);

		if (commonCode == null) {
			return ResponseEntity.status(401).body(BaseResponseBody.of(401, "Fail"));
		}

		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}

	@PatchMapping("/updateCommonCode/{id}/{kind}")
	@ApiOperation(value = "commonCode수정", notes = "해당 id값의 commonCode의 kind를 수정")
	public ResponseEntity<BaseResponseBody> updateCommonCode(@PathVariable Long id, @PathVariable String kind) {
		CommonCode commonCode = adminService.updateCommonCodeById(id, kind);

		if (commonCode == null) {
			return ResponseEntity.status(401).body(BaseResponseBody.of(401, "Fail"));
		}

		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}

	@DeleteMapping("/deleteCommonCode/{id}")
	@ApiOperation(value = "commonCode삭제", notes = "해당 id값의 commonCode 삭제")
	public ResponseEntity<BaseResponseBody> deleteCommonCode(@PathVariable Long id) {
		try {
			adminService.deleteCommonCodeById(id);
			return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
		} catch (Exception e) {
			return ResponseEntity.status(401).body(BaseResponseBody.of(401, "Fail"));
		}
	}

	@GetMapping("/getDetailsCodeById/{id}")
	@ApiOperation(value = "detailsCode조회", notes = "commonCode id값을 받아 해당하는 detailsCode의 목록을 조회")
	public ResponseEntity<List<DetailsCodeRes>> getDetailsCodeById(@PathVariable Long id) {
		List<DetailsCodeRes> list = adminService.getDetailsCodeById(id);
		return ResponseEntity.status(200).body(list);

	}

	@PostMapping("/setDetailsCode/{name}/{type}")
	@ApiOperation(value = "detailsCode추가", notes = "DB에 detailsCode를 추가")
	public ResponseEntity<BaseResponseBody> setDetailsCode(@PathVariable String name, @PathVariable Long type) {
		DetailsCode detailsCode = adminService.createDetailsCode(name, type);

		if (detailsCode == null) {
			return ResponseEntity.status(401).body(BaseResponseBody.of(401, "Fail"));
		}

		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}

	@PatchMapping("/updateDetailsCode/{id}/{name}")
	@ApiOperation(value = "detailsCode수정", notes = "해당 id값의 detailsCode의 name을 수정")
	public ResponseEntity<BaseResponseBody> updateDetailsCode(@PathVariable Long id, @PathVariable String name) {
		DetailsCode detailsCode = adminService.updateDetailsCodeById(id, name);

		if (detailsCode == null) {
			return ResponseEntity.status(401).body(BaseResponseBody.of(401, "Fail"));
		}

		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}

	@DeleteMapping("/deleteDetailsCode/{id}")
	@ApiOperation(value = "detailsCode삭제", notes = "해당 id값의 detailsCode 삭제")
	public ResponseEntity<BaseResponseBody> deleteDetailsCode(@PathVariable Long id) {
		try {
			adminService.deleteDetailsCodeById(id);
			return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
		} catch (Exception e) {
			return ResponseEntity.status(401).body(BaseResponseBody.of(401, "Fail"));
		}
	}

	@PostMapping("/notify")
	@ApiOperation(value = "신고 처리", notes = "신고 처리 기록 입력")
	public ResponseEntity<BaseResponseBody> setNotify(@RequestBody NotifyRegisterReq notifyRegisterReq) {
		Notify notify = adminService.createNotify(notifyRegisterReq);

		if (notify == null) {
			return ResponseEntity.status(401).body(BaseResponseBody.of(401, "Fail"));
		}

		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}

}