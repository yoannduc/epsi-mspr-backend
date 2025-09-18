package com.acme.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.acme.application.dtos.ChiffreAffairesMoisDTO;
import com.acme.application.entities.ChiffreAffairesMoisEntity;
import com.acme.application.exceptions.ChiffreAffairesMoisNotFoundException;
import com.acme.application.mappers.ChiffreAffairesMoisMapper;
import com.acme.application.repositories.ChiffreAffairesMoisRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChiffreAffairesMoisServiceImpl implements ChiffreAffairesMoisService {
	private ChiffreAffairesMoisRepository repo;
	private ChiffreAffairesMoisMapper mapper;
	
	public ChiffreAffairesMoisServiceImpl(ChiffreAffairesMoisRepository repo, ChiffreAffairesMoisMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	@Override
	public List<ChiffreAffairesMoisDTO> getAll() {
		return mapper.fromListEntity(repo.findAll());
	}

	@Override
	public ChiffreAffairesMoisDTO findByMois(Short mois) throws ChiffreAffairesMoisNotFoundException {
		Optional<ChiffreAffairesMoisEntity> el = repo.findById(mois);
		if (el.isEmpty()) {
			throw new ChiffreAffairesMoisNotFoundException();
		}
		return mapper.fromEntity(el.get());
	}
	
	
}
