package com.acme.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.acme.application.dtos.ProduitsNonPopulairesDTO;
import com.acme.application.mappers.ProduitsNonPopulairesMapper;
import com.acme.application.repositories.ProduitsNonPopulairesRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProduitsNonPopulairesServiceImpl implements ProduitsNonPopulairesService {
	private ProduitsNonPopulairesRepository repo;
	private ProduitsNonPopulairesMapper mapper;
	
	public ProduitsNonPopulairesServiceImpl(ProduitsNonPopulairesRepository repo, ProduitsNonPopulairesMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	@Override
	public List<ProduitsNonPopulairesDTO> getAll() {
		return mapper.fromListEntity(repo.findAll());
	}
}
