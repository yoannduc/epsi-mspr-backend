package com.acme.application.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acme.application.dtos.SigninDTO;
import com.acme.application.dtos.SigninResponseDTO;
import com.acme.application.services.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	private UserService srv;
	
	public UserController(UserService srv) {
		super();
		this.srv = srv;
	}

	@PostMapping(value="/auth/signin", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public SigninResponseDTO signin(@RequestBody SigninDTO dto) {
		return srv.signin(dto);
	}
}
