package com.acme.application.services;

import org.springframework.stereotype.Service;

import com.acme.application.dtos.ChiffreAffairesTotalDTO;
import com.acme.application.mappers.ChiffreAffairesTotalMapper;
import com.acme.application.repositories.ChiffreAffairesTotalRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChiffreAffairesTotalServiceImpl implements ChiffreAffairesTotalService {
	private ChiffreAffairesTotalRepository repo;
	private ChiffreAffairesTotalMapper mapper;
	
	public ChiffreAffairesTotalServiceImpl(ChiffreAffairesTotalRepository repo, ChiffreAffairesTotalMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	@Override
	public ChiffreAffairesTotalDTO get() {
		return mapper.fromEntity(repo.findAll().getFirst());
	}
	
	
}
