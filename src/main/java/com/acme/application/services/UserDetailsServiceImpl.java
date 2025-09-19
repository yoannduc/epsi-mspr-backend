package com.acme.application.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.acme.application.entities.UserEntity;
import com.acme.application.exceptions.UserNotFoundException;
import com.acme.application.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final UserRepository repo;

	  public UserDetailsServiceImpl(UserRepository repo) {
	    this.repo = repo;
	  }

	  @Override
	  public UserDetails loadUserByUsername(String email) {

	    Optional<UserEntity> user = repo.findByLogin(email);
	    if (user.isEmpty()) {
	    	throw new UserNotFoundException();
	    }

	    return org.springframework.security.core.userdetails.User.builder()
	        .username(user.get().getLogin())
	        .password(user.get().getPassword())
	        .build();
	  }
}
