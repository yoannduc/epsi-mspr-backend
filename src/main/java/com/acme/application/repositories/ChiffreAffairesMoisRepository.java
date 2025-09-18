package com.acme.application.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.application.entities.ChiffreAffairesMoisEntity;

public interface ChiffreAffairesMoisRepository extends JpaRepository<ChiffreAffairesMoisEntity, Short> {
	Optional<ChiffreAffairesMoisEntity> findById(Short mois);
}
