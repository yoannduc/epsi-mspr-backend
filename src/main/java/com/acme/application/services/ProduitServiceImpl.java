package com.acme.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.acme.application.dtos.ProduitDTO;
import com.acme.application.entities.ProduitEntity;
import com.acme.application.exceptions.ClientNotFoundException;
import com.acme.application.exceptions.ProduitNotFoundException;
import com.acme.application.exceptions.ProduitSkuAlreadyExistsException;
import com.acme.application.mappers.ProduitMapper;
import com.acme.application.objectmerger.ObjectMerger;
import com.acme.application.repositories.ProduitRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProduitServiceImpl implements ProduitService {
	private ProduitRepository repo;
	private ProduitMapper mapper;
	
	public ProduitServiceImpl(ProduitRepository repo, ProduitMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	@Override
	public List<ProduitDTO> getAll() {
		return mapper.fromListEntity(repo.findAll());
	}

	@Override
	public List<ProduitDTO> findByCategorie(String categorie) {
		return mapper.fromListEntity(repo.findByCategorie(categorie));
	}

	@Override
	public ProduitDTO findById(Short id) {
		Optional<ProduitEntity> entity = repo.findById(id);
		if (entity.isEmpty()) {
			throw new ProduitNotFoundException();
		}
		return mapper.fromEntity(entity.get());
	}

	@Override
	public ProduitDTO saveNew(ProduitDTO dto) throws ProduitSkuAlreadyExistsException {
		if (repo.existsBySku(dto.getSku())) {
			throw new ProduitSkuAlreadyExistsException();
		}
		
		return mapper.fromEntity(repo.save(mapper.fromDTO(dto)));
	}

	@Override
	public ProduitDTO update(Short id, ProduitDTO dto) throws ProduitNotFoundException {
		Optional<ProduitEntity> entity = repo.findById(id);
		if (entity.isEmpty()) {
			throw new ClientNotFoundException();
		}
		
		ProduitEntity inputEntity = mapper.fromDTO(dto);
		inputEntity.setId(null);
		inputEntity.setSku(null);
		
		return mapper.fromEntity(repo.save(ObjectMerger.merge(inputEntity, entity.get())));
	}

	@Override
	public ProduitDTO delete(Short id) throws ProduitNotFoundException {
		Optional<ProduitEntity> entity = repo.findById(id);
		if (entity.isEmpty()) {
			throw new ClientNotFoundException();
		}
		
		repo.deleteById(id);
		return mapper.fromEntity(entity.get());
	}
	
	
}
