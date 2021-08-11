package com.ssafy.api.response;
import io.openvidu.java.client.Session;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("ConferenceResponse")
public class ConferenceRes {
	Session session;
	String token;
}
