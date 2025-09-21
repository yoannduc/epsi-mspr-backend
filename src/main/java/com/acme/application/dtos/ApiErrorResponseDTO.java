package com.acme.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor @ToString @Builder
@Getter @Setter
public class ApiErrorResponseDTO {
	private int errorCode;
	private String description;
}
