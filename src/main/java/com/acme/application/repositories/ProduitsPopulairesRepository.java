package com.acme.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.application.entities.ProduitsPopulairesEntity;

public interface ProduitsPopulairesRepository extends JpaRepository<ProduitsPopulairesEntity, Short> {

}
