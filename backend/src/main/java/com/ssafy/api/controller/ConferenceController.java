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

import com.ssafy.api.request.ConferenceRegisterReq;
import com.ssafy.api.service.ConferenceService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.Conference;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//import io.openvidu.java.client.*;

//import io.openvidu.java.client.ConnectionProperties;
//import io.openvidu.java.client.ConnectionType;
import io.openvidu.java.client.OpenVidu;
import io.openvidu.java.client.OpenViduHttpException;
import io.openvidu.java.client.OpenViduJavaClientException;
import io.openvidu.java.client.OpenViduRole;
import io.openvidu.java.client.Session;


/*
 공부방 관련 요청 처리를 위한 컨트롤러 요청
*/
@Api(value ="공부방API", tags= {"Conference"})
@RestController
@RequestMapping("/api/v1/conference")
public class ConferenceController {
	@Autowired
	ConferenceService conferenceService;
	
	private OpenVidu openVidu;
	// URL where our OpenVidu server is listening
	private String OPENVIDU_URL;
	// Secret shared with our OpenVidu server
	private String SECRET;
	
	
	
	//카테고리를 받아와서
	
		// 해당하는 방이 없으면 방을 생성후, 세션값 토큰값 리턴 , DB에 해당 방 저장(noewpeople = 1 , maxpeople = 6 , 날짜시간 현재로, 공부방 종료 날짜 종료시간은 null ) 
		// 해당하는 방이 있고  maxpeople < 6 이라면, 해당 방의 세션값 토큰값 리턴 , DB에 nowpeople값 ++;
		// 해당하는 방이 있는데 maxpeople == 6 이라면, 새로운방을 만들어서 ? 	
	
	//카테고리를 받아와서 
		// 해당 카테고리에 대한 
	
	
	@GetMapping("/{category}")
	@ApiOperation(value="해당 카테고리에 맞는 입장버튼 클릭",notes ="")
	public ResponseEntity<Optional<Conference>> enterConference (@PathVariable Integer category) throws OpenViduJavaClientException, OpenViduHttpException{
		Optional<Conference> conference = conferenceService.getConference(category);
		// Build connectionProperties object with the serverData and the role
//		ConnectionProperties connectionProperties = new ConnectionProperties.Builder().type(ConnectionType.WEBRTC)
//				.role(role).data(serverData).build();
		
		if(conference == null) { // 해당카테고리에 맞는 방이 없으면
			Session session = this.openVidu.createSession();
			
//			String token = session.createConnection(connectionProperties).getToken();
			
			return ResponseEntity.status(200).body(conference);
			
		}else { // 해당카테고리에 맞는 방이 있으면
			
		}
		
		return null;
	}
	
	// 퇴장시
		
		
	@PostMapping("/regist")
	@ApiOperation(value="공부방 생성",notes = "")
//	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
//		@ApiResponse(code = 404, message = "공부방 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<? extends BaseResponseBody> registerConference(@RequestBody ConferenceRegisterReq registerInfo){
		Optional<Conference> conference = conferenceService.createConference(registerInfo);		
		if(conference!=null) {			
			return ResponseEntity.status(200).body(BaseResponseBody.of(200,"Success"));
		}else {
			return ResponseEntity.status(500).body(BaseResponseBody.of(500,"Fail"));
		}
	}
	
	@GetMapping("/show/{category}")
	@ApiOperation(value="공부방 조회", notes= "카테고리에 해당하는 공부방 조회")
	public ResponseEntity<Optional<Conference>> showConference(@PathVariable Integer category){
		Optional<Conference> conference = conferenceService.getConference(category);
		if(conference!=null) {			
			return ResponseEntity.status(200).body(conference);
		}else {
			return ResponseEntity.status(500).body(conference);
		}
	}
	
	@PatchMapping("/update/{id}")
	@ApiOperation(value="공부방 업데이트", notes="인원이 입장하거나 퇴장할때 공부방 업데이트")
	public ResponseEntity<? extends BaseResponseBody> updateConference(@PathVariable Long id, @RequestBody Boolean isEnter){
		Conference conference = conferenceService.modifyConference(id, isEnter);
		if(conference!=null) {			
			return ResponseEntity.status(200).body(BaseResponseBody.of(200,"Success"));
		}else {
			return ResponseEntity.status(500).body(BaseResponseBody.of(500,"Fail"));
		}
	}
	
	@PatchMapping("/exit/{id}")
	@ApiOperation(value="공부방 종료", notes= "공부방에서 모두가 나오면 해당공부방에 종료시간,날짜를 업데이트")
	public ResponseEntity<? extends BaseResponseBody> exitConference(@PathVariable Long id, @RequestBody ConferenceRegisterReq conferenceRegisterReq){
		Conference conference = conferenceService.EndConference(id, conferenceRegisterReq);
		if(conference!=null) {			
			return ResponseEntity.status(200).body(BaseResponseBody.of(200,"Success"));
		}else {
			return ResponseEntity.status(500).body(BaseResponseBody.of(500,"Fail"));
		}
	}
	
	
}
