package com.acme.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.acme.application.dtos.ChiffreAffairesAnneesDTO;
import com.acme.application.entities.ChiffreAffairesAnneesEntity;
import com.acme.application.exceptions.ChiffreAffairesAnneesNotFoundException;
import com.acme.application.mappers.ChiffreAffairesAnneesMapper;
import com.acme.application.repositories.ChiffreAffairesAnneesRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChiffreAffairesAnneesServiceImpl implements ChiffreAffairesAnneesService {
	private ChiffreAffairesAnneesRepository repo;
	private ChiffreAffairesAnneesMapper mapper;
	
	public ChiffreAffairesAnneesServiceImpl(ChiffreAffairesAnneesRepository repo, ChiffreAffairesAnneesMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	@Override
	public List<ChiffreAffairesAnneesDTO> getAll() {
		return mapper.fromListEntity(repo.findAll());
	}

	@Override
	public ChiffreAffairesAnneesDTO findByAnnee(Short annee) throws ChiffreAffairesAnneesNotFoundException {
		Optional<ChiffreAffairesAnneesEntity> el = repo.findByAnnee(annee);
		if (el.isEmpty()) {
			throw new ChiffreAffairesAnneesNotFoundException();
		}
		return mapper.fromEntity(el.get());
	}
	
	
}
