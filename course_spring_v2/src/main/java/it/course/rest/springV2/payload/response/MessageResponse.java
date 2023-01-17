package it.course.rest.springV2.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class MessageResponse {

	@Getter
	@Setter
	private String message;

	public MessageResponse(String message) {
	    this.message = message;
	  }

}
