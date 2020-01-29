package it.its.testEmployees.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponseDto<T> {

	private Date timestamp;
	private int status;
	private String error;
	private String message;
	private Object response;

}
