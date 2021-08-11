package com.ssafy.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.request.UserHistoryRegisterReq;
import com.ssafy.api.response.UserHistoryRes;
import com.ssafy.api.service.UserHistoryService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.UserHistory;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/*
공부방 관련 요청 처리를 위한 컨트롤러 요청
*/
@Api(value ="회원 히스토리 API", tags= {"UserHistory"})
@RestController
@RequestMapping("/api/v1/userhistory")
public class UserHistoryController {
	
	@Autowired
	UserHistoryService userHistoryService;
}
//	@PostMapping("/regist")
//	@ApiOperation(value="회원 히스토리 생성",notes = "")
//	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
//		@ApiResponse(code = 404, message = "사용자 없음"), @ApiResponse(code = 500, message = "서버 오류") })
//	public ResponseEntity<UserHistoryRes> registerUserHistory(@RequestBody UserHistoryRegisterReq registerInfo){
//		Optional<UserHistory> userHistory = userHistoryService.createUserHistory(registerInfo);
//		UserHistoryRes res = userHistoryService.selectUserHistory(userHistory.get().getId());
//		if(!userHistory.isPresent() || res == null) {
//			return ResponseEntity.status(404).body(null);
//		}
//		return ResponseEntity.status(200).body(res);
//	}
//	
//	@GetMapping("/{historyId}")
//	@ApiOperation(value="히스토리 아이디별 히스토리 조회",notes = "")
//	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
//		@ApiResponse(code = 404, message = "사용자 없음"), @ApiResponse(code = 500, message = "서버 오류") })
//	public ResponseEntity<UserHistoryRes> getUserHistory(@PathVariable Long historyId){
//		Optional<UserHistory> userHistory = userHistoryService.getUserHistoryById(historyId);
//		UserHistoryRes res = userHistoryService.selectUserHistory(userHistory.get().getId());
//		if(!userHistory.isPresent() || res == null) {
//			return ResponseEntity.status(404).body(null);
//		}
//		return ResponseEntity.status(200).body(res);
//	}
//	
//	@GetMapping("/list/{userId}")
//	@ApiOperation(value="사용자별 히스토리 조회",notes = "")
//	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
//		@ApiResponse(code = 404, message = "사용자 없음"), @ApiResponse(code = 500, message = "서버 오류") })
//	public ResponseEntity<List<UserHistoryRes>> getListUserHistory(@PathVariable Long userId){
//		List<UserHistory> userHistory = userHistoryService.getUserHistoryByUserId(userId);
//		List<UserHistoryRes> res = new ArrayList<UserHistoryRes>();
//		
//		for(UserHistory uh : userHistory) {
//			res.add(userHistoryService.selectUserHistory(uh.getId()));
//		}
//		return ResponseEntity.status(200).body(res);
//	}
//	
//	
//	@PatchMapping("/endregist/{historyId}")
//	@ApiOperation(value="회원 히스토리 종료 시간 삽입",notes = "")
//	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
//		@ApiResponse(code = 404, message = "사용자 없음"), @ApiResponse(code = 500, message = "서버 오류") })
//	public ResponseEntity<UserHistoryRes> updateUserHistory(@PathVariable Long historyId){
//		Optional<UserHistory> userHistory = userHistoryService.UpdateUserHistory(historyId);
//		UserHistoryRes res = userHistoryService.selectUserHistory(userHistory.get().getId());
//		if(!userHistory.isPresent() || res == null) {
//			return ResponseEntity.status(404).body(null);
//		}
//		return ResponseEntity.status(200).body(res);
//	}
//	
//	@DeleteMapping("/{historyId}")
//	@ApiOperation(value="회원 히스토리 삭제",notes = "")
//	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
//		@ApiResponse(code = 404, message = "사용자 없음"), @ApiResponse(code = 500, message = "서버 오류") })
//	public ResponseEntity<BaseResponseBody> deleteUserHistory(@PathVariable Long historyId){
//		userHistoryService.deleteUserHistoryById(historyId);
//		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
//	}
	
