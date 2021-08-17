package com.ssafy.api.controller;

import java.sql.Date;
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

import com.ssafy.api.request.TimerRegisterReq;
import com.ssafy.api.response.CalendarRes;
import com.ssafy.api.response.TimerRes;
import com.ssafy.api.service.CalendarService;
import com.ssafy.api.service.TimerService;
import com.ssafy.api.service.UserService;
import com.ssafy.db.entity.Calendar;
import com.ssafy.db.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 타이머 관련 요청 처리를 위한 컨트롤러 정의.
 */
@Api(value = "타이머 API", tags = { "Timer" })
@RestController
@RequestMapping("/api/v1/timer")
public class TimerController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	CalendarService calendarService;
	
	@Autowired
	TimerService timerService;
	
	@PostMapping("/regist")
	@ApiOperation(value = "캘린더에 타이머를 등록한다", notes = "캘린더에 타이머를 등록한다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	
	public ResponseEntity<TimerRes> registerTimer(
			@RequestBody @ApiParam(value = "오늘 메모 정보", required = true) TimerRegisterReq registerInfo) {
		Long userId = registerInfo.getUserId();
		Date date = registerInfo.getDate();
		Optional<Calendar> cal_check = calendarService.getCalendarByUserIdAndDate(userId, date);
		if(cal_check.isPresent()) { // 값이 있으면 update
			Long id = cal_check.get().getId();
			Optional<Calendar> calendar = timerService.modifyTimer(id, registerInfo);
			TimerRes res = timerService.selectTimer(calendar.get().getId());
			return ResponseEntity.status(200).body(res);
		}
		Optional<Calendar> calendar = timerService.createTimer(registerInfo);
		TimerRes res = timerService.selectTimer(calendar.get().getId());
		return ResponseEntity.status(200).body(res);
	}	
	
	@GetMapping("/{userId}/{date}")
	@ApiOperation(value = "오늘의 공부시간을 조회한다", notes = "오늘의 공부시간을 조회한다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<TimerRes> getTimer(@PathVariable Long userId, @PathVariable Date date) {
		Optional<Calendar> calendar = calendarService.getCalendarByUserIdAndDate(userId, date);
		if(!calendar.isPresent()) {
			Optional<User> user = userService.getUserById(userId);
			if(!user.isPresent()) { // 사용자가 없다
				return ResponseEntity.status(404).body(null); 
			} else {
				TimerRes res = new TimerRes();
				res.setId((long) 0);
				res.setUserid(userId);
				res.setDate(date);
				res.setStudyTime(0);
				return ResponseEntity.status(200).body(res); // 0초로 주고 싶은데,,				
			}
		}
		Long id = calendar.get().getId();
		TimerRes res = timerService.selectTimer(id);
		return ResponseEntity.status(200).body(res);
	}
	
	@PatchMapping("/modify")
	@ApiOperation(value = "캘린더에 타이머를 수정한다", notes = "캘린더에 타이머를 수정한다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	
	public ResponseEntity<TimerRes> modifyTimer(
			@RequestBody @ApiParam(value = "오늘 메모 정보", required = true) TimerRegisterReq registerInfo) {
		Optional<Calendar> cal_check = calendarService.getCalendarByUserIdAndDate(registerInfo.getUserId(), registerInfo.getDate());
		if(!cal_check.isPresent()) {
			return ResponseEntity.status(404).body(null);
		}
		Long id = cal_check.get().getId();
		Optional<Calendar> calendar = timerService.modifyTimer(id, registerInfo);
		TimerRes res = timerService.selectTimer(calendar.get().getId());
		return ResponseEntity.status(200).body(res);
	}

	@GetMapping("/view/{userId}/{date}")
	@ApiOperation(value = "다른 회원의 캘린더 조회", notes = "공부방 내 다른 회원의 닉네임과 선택한 날짜를 가지고 그날의 캘린더 조회")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
		@ApiResponse(code = 404, message = "사용자 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<CalendarRes> viewCalender(@PathVariable Long userId, @PathVariable Date date) {
		Optional<User> user = userService.getUserById(userId);
		if(!user.isPresent()) { // 없는 사용자
			return ResponseEntity.status(404).body(null);
		}
		CalendarRes res = new CalendarRes();
		Optional<Calendar> calendar = calendarService.getCalendarByUserIdAndDate(userId, date);
		boolean is_open = user.get().getIsOpen();
		
		if(!calendar.isPresent()) { // 회원은 있는데 값이 없으면
			res.setStudyTime(0);
		} else if(!is_open) {
			res.setStudyTime(calendar.get().getStudyTime());
		}
		if(is_open) {
			CalendarRes res2 = calendarService.selectCalendar(calendar.get().getId());
			return ResponseEntity.status(200).body(res2);
		}
		return ResponseEntity.status(200).body(res);
	}
}
