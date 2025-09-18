package com.acme.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.acme.application.dtos.ProduitsPopulairesDTO;
import com.acme.application.mappers.ProduitsPopulairesMapper;
import com.acme.application.repositories.ProduitsPopulairesRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProduitsPopulairesServiceImpl implements ProduitsPopulairesService {
	private ProduitsPopulairesRepository repo;
	private ProduitsPopulairesMapper mapper;
	
	public ProduitsPopulairesServiceImpl(ProduitsPopulairesRepository repo, ProduitsPopulairesMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	@Override
	public List<ProduitsPopulairesDTO> getAll() {
		return mapper.fromListEntity(repo.findAll());
	}
}
