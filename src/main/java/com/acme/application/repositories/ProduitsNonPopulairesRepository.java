package com.acme.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.application.entities.ProduitsNonPopulairesEntity;

public interface ProduitsNonPopulairesRepository extends JpaRepository<ProduitsNonPopulairesEntity, Short> {

}
