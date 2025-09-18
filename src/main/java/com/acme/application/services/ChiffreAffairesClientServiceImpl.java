package com.acme.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.acme.application.dtos.ChiffreAffairesClientDTO;
import com.acme.application.entities.ChiffreAffairesClientEntity;
import com.acme.application.exceptions.ChiffreAffairesClientNotFoundException;
import com.acme.application.mappers.ChiffreAffairesClientMapper;
import com.acme.application.repositories.ChiffreAffairesClientRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChiffreAffairesClientServiceImpl implements ChiffreAffairesClientService {
	private ChiffreAffairesClientRepository repo;
	private ChiffreAffairesClientMapper mapper;
	
	public ChiffreAffairesClientServiceImpl(ChiffreAffairesClientRepository repo, ChiffreAffairesClientMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	@Override
	public List<ChiffreAffairesClientDTO> getAll() {
		return mapper.fromListEntity(repo.findAll());
	}

	@Override
	public ChiffreAffairesClientDTO findByClientId(Short id) throws ChiffreAffairesClientNotFoundException {
		Optional<ChiffreAffairesClientEntity> el = repo.findById(id);
		if (el.isEmpty()) {
			throw new ChiffreAffairesClientNotFoundException();
		}
		return mapper.fromEntity(el.get());
	}
	
	
}
