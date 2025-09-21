package com.acme.application.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.acme.application.dtos.SigninDTO;
import com.acme.application.dtos.SigninResponseDTO;
import com.acme.application.entities.UserEntity;
import com.acme.application.exceptions.SigninAttemptFailedException;
import com.acme.application.exceptions.UserNotFoundException;
import com.acme.application.helpers.JwtHelper;
import com.acme.application.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	private UserRepository repo;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public UserServiceImpl(UserRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public SigninResponseDTO signin(SigninDTO dto) throws SigninAttemptFailedException, UsernameNotFoundException {
		Optional<UserEntity> usr = repo.findByLogin(dto.getLogin());
		if (usr.isEmpty()) {
			throw new UserNotFoundException();
		}
		
		if (!passwordEncoder.matches(dto.getPassword(), usr.get().getPassword())) {
			throw new SigninAttemptFailedException();
		}
		
		return SigninResponseDTO.builder().username(dto.getLogin()).jwt(JwtHelper.generateToken(dto.getLogin())).build();
	}
}
