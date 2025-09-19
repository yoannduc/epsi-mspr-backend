package com.acme.application.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.acme.application.entities.UserEntity;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<UserEntity, Short> {
	Optional<UserEntity> findByLogin(String login);
}
