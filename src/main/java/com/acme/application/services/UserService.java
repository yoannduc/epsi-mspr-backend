package com.acme.application.services;

import org.springframework.stereotype.Service;

import com.acme.application.dtos.SigninDTO;
import com.acme.application.dtos.SigninResponseDTO;
import com.acme.application.exceptions.SigninAttemptFailedException;
import com.acme.application.exceptions.UserNotFoundException;

@Service
public interface UserService {
	SigninResponseDTO signin(SigninDTO dto) throws SigninAttemptFailedException, UserNotFoundException;
}
