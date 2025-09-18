package com.acme.application.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.acme.application.entities.ClientEntity;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<ClientEntity, Short> {
	List<ClientEntity> findByVilleAddr(String ville);
	List<ClientEntity> findByCodePostalAddr(String codePostal);
	List<ClientEntity> findByNom(String nom);
	List<ClientEntity> findByMailContaining(String mail);
	Optional<ClientEntity> findById(Short id);
	Optional<ClientEntity> findByMail(String mail);
	boolean existsByMail(String mail);
}
