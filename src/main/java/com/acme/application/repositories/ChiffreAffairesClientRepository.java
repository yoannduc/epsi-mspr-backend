package com.acme.application.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.application.entities.ChiffreAffairesClientEntity;

public interface ChiffreAffairesClientRepository extends JpaRepository<ChiffreAffairesClientEntity, Short> {
	Optional<ChiffreAffairesClientEntity> findById(Short id);
}
