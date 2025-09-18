package com.acme.application.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.acme.application.entities.CommandeEntity;

@RepositoryRestResource
public interface CommandeRepository extends JpaRepository<CommandeEntity, Short> {
	List<CommandeEntity> findByIdClient(Short idClient);
	List<CommandeEntity> findByIdClientIn(List<Short> idClientList);
	Optional<CommandeEntity> findById(Short id);
}
