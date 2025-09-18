package com.acme.application.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.acme.application.entities.ChiffreAffairesAnneesEntity;

@RepositoryRestResource
public interface ChiffreAffairesAnneesRepository extends JpaRepository<ChiffreAffairesAnneesEntity, Short> {
	Optional<ChiffreAffairesAnneesEntity> findByAnnee(Short annee);
}
