package com.acme.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.acme.application.entities.ProduitsNonPopulairesEntity;

@RepositoryRestResource
public interface ProduitsNonPopulairesRepository extends JpaRepository<ProduitsNonPopulairesEntity, Short> {

}
