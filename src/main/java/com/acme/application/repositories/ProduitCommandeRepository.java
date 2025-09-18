package com.acme.application.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.acme.application.entities.ProduitCommandeEntity;

@RepositoryRestResource
public interface ProduitCommandeRepository extends JpaRepository<ProduitCommandeEntity, Short> {
	Optional<ProduitCommandeEntity> findById(Short id);
	List<ProduitCommandeEntity> findByIdCommande(Short id);
}
