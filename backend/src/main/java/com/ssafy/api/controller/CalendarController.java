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

import com.ssafy.api.request.CalendarRegisterReq;
import com.ssafy.api.request.CalendarUpdateReq;
import com.ssafy.api.response.CalendarRes;
import com.ssafy.api.response.UserRes;
import com.ssafy.api.service.CalendarService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.Calendar;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 캘린더 관련 요청 처리를 위한 컨트롤러 정의.
 */
@Api(value = "캘린더 API", tags = { "Calendar" })
@RestController
@RequestMapping("/api/v1/calendar")
public class CalendarController {

	@Autowired
	CalendarService calendarService;

	@PostMapping("/regist")
	@ApiOperation(value = "캘린더에 오늘 다짐 및 일기 등록", notes = "캘린더에 오늘 다짐 및 일기를 등록한다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"), @ApiResponse(code = 500, message = "서버 오류") })

	public ResponseEntity<? extends BaseResponseBody> registerCalendar(
			@RequestBody @ApiParam(value = "오늘 메모 정보", required = true) CalendarRegisterReq registerInfo) {

		Optional<Calendar> calendar = calendarService.createCalendar(registerInfo);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}

	@GetMapping("/list/{userId}")
	@ApiOperation(value = "캘린더에 오늘 다짐 및 일기  보기", notes = "캘린더에 저장된 오늘 다짐 및 일기를 본다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	
	public ResponseEntity<List<Calendar>> getCalendarInfo(@PathVariable Long userId) {
		List<Calendar> calendar = calendarService.getCalendarByUserId(userId);
		return ResponseEntity.status(200).body(calendar);
	}
	
	@PatchMapping("/modify/{id}")
	@ApiOperation(value = "캘린더에 오늘 다짐 및 일기 수정", notes = "캘린더에 오늘 다짐 및 일기를 수정한다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	
	public ResponseEntity<? extends BaseResponseBody> modifyCalendar(@PathVariable Long id, @RequestBody CalendarUpdateReq updateInfo) {
		Calendar calendar = calendarService.modifyCalendar(id, updateInfo);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "캘린더에 오늘 다짐 및 일기 삭제", notes = "캘린더에 오늘 다짐 및 일기를 삭제한다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<? extends BaseResponseBody> deleteCalendar(@PathVariable Long id){
		calendarService.deleteCalendarById(id);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
}
