package com.ssafy.api.controller;

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

import com.ssafy.api.request.CalendarRegisterReq;
import com.ssafy.api.request.ConferenceRegisterReq;
import com.ssafy.api.request.UserHistoryRegisterReq;
import com.ssafy.api.response.UserHistoryRes;
import com.ssafy.api.service.ConferenceService;
import com.ssafy.api.service.UserHistoryService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.Conference;
import com.ssafy.db.entity.UserHistory;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/*
 공부방 관련 요청 처리를 위한 컨트롤러 요청
*/
@Api(value ="공부방API", tags= {"Conference"})
@RestController
@RequestMapping("/api/v1/conference")
public class ConferenceController {
	
	@Autowired
	ConferenceService conferenceService;
	
	@Autowired
	UserHistoryService userHistoryService;
	
	//입장시
	@GetMapping("/enterroom/{userId}/{category}")
	@ApiOperation(value="해당 카테고리에 맞는 입장버튼 클릭",notes ="")
	
	public ResponseEntity<Optional<String>> enterConference (@PathVariable Long userId, @PathVariable Integer category) {
		// 방을 찾아온다.
		Optional<String> sessionName = conferenceService.getConference(category);
		if(!sessionName.isPresent()) { // 카테고리에 해당하는 방이 없거나 , 6명이하인 방이없거나
			sessionName = conferenceService.createConference(userId, category);
		} 
		return ResponseEntity.status(200).body(sessionName);
		
		//		Optional<UserHistoryRegisterReq> conference  = conferenceService.getConference(registerInfo);
//	//	UserHistoryRegisterReq uhr = conferenceService.getUserHistory(userId);
//		Optional<UserHistory> userHistory = userHistoryService.createUserHistory(uhr);
//		UserHistoryRes res = userHistoryService.selectUserHistory(userHistory.get().getId());
//		if(!sessionName.isPresent()) { //카테고리에 해당하는 방이 없거나 , 6명이하인 방이없거나
//			sessionName = conferenceService.createConference(category);
//			return ResponseEntity.status(200).body(sessionName);
//		}else { // 카테고리에 해당하는 방이 있으면
//			return ResponseEntity.status(200).body(sessionName);
//		}
	}
	
	// 퇴장시
	
	
	
	
		
//	@PostMapping("/regist")
//	@ApiOperation(value="공부방 생성",notes = "")
//	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
//		@ApiResponse(code = 404, message = "공부방 없음"), @ApiResponse(code = 500, message = "서버 오류") })
//	public ResponseEntity<? extends BaseResponseBody> registerConference(@RequestBody ConferenceRegisterReq registerInfo){
//		Optional<Conference> conference = conferenceService.createConference(registerInfo);		
//		if(conference!=null) {			
//			return ResponseEntity.status(200).body(BaseResponseBody.of(200,"Success"));
//		}else {
//			return ResponseEntity.status(500).body(BaseResponseBody.of(500,"Fail"));
//		}
//	}
//	
//	@GetMapping("/show/{category}")
//	@ApiOperation(value="공부방 조회", notes= "카테고리에 해당하는 공부방 조회")
//	public ResponseEntity<Optional<Conference>> showConference(@PathVariable Integer category){
//		return null;
//	}
//	
//	@PatchMapping("/update/{id}")
//	@ApiOperation(value="공부방 업데이트", notes="인원이 입장하거나 퇴장할때 공부방 업데이트")
//	public ResponseEntity<? extends BaseResponseBody> updateConference(@PathVariable Long id, @RequestBody Boolean isEnter){
//		Conference conference = conferenceService.modifyConference(id, isEnter);
//		if(conference!=null) {			
//			return ResponseEntity.status(200).body(BaseResponseBody.of(200,"Success"));
//		}else {
//			return ResponseEntity.status(500).body(BaseResponseBody.of(500,"Fail"));
//		}
//	}
//	
//	@PatchMapping("/exit/{id}")
//	@ApiOperation(value="공부방 종료", notes= "공부방에서 모두가 나오면 해당공부방에 종료시간,날짜를 업데이트")
//	public ResponseEntity<? extends BaseResponseBody> exitConference(@PathVariable Long id, @RequestBody ConferenceRegisterReq conferenceRegisterReq){
//		Conference conference = conferenceService.EndConference(id, conferenceRegisterReq);
//		if(conference!=null) {			
//			return ResponseEntity.status(200).body(BaseResponseBody.of(200,"Success"));
//		}else {
//			return ResponseEntity.status(500).body(BaseResponseBody.of(500,"Fail"));
//		}
//	}
	
	
}
