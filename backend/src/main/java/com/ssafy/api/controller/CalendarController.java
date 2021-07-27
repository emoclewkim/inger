package com.ssafy.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.request.CalendarRegisterReq;
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

	@PostMapping()
	@ApiOperation(value = "캘린더에 오늘 다짐 및 일기 등록", notes = "캘린더에 오늘 다짐 및 일기를 등록한다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"), @ApiResponse(code = 500, message = "서버 오류") })

	public ResponseEntity<? extends BaseResponseBody> register(
			@RequestBody @ApiParam(value = "오늘 메모 정보", required = true) CalendarRegisterReq registerInfo) {

		Optional<Calendar> calendar = calendarService.createCalendar(registerInfo);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}

}
