package com.acme.application.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.acme.application.entities.ProduitEntity;

@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<ProduitEntity, Short> {
	List<ProduitEntity> findByCategorie(String categorie);
	Optional<ProduitEntity> findById(Short id);
	boolean existsBySku(String sku);
}
