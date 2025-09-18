package com.acme.application.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.acme.application.dtos.ProduitCommandeDTO;
import com.acme.application.entities.ProduitCommandeEntity;
import com.acme.application.exceptions.ProduitCommandeNotFoundException;
import com.acme.application.mappers.ProduitCommandeMapper;
import com.acme.application.repositories.ProduitCommandeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProduitCommandeServiceImpl implements ProduitCommandeService {
	private ProduitCommandeRepository repo;
	private ProduitCommandeMapper mapper;
	
	public ProduitCommandeServiceImpl(ProduitCommandeRepository repo, ProduitCommandeMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	@Override
	public ProduitCommandeDTO findById(Short id) {
		Optional<ProduitCommandeEntity> entity = repo.findById(id);
		if (entity.isEmpty()) {
			throw new ProduitCommandeNotFoundException();
		}
		return mapper.fromEntity(entity.get());
	}
	
	

	@Override
	public List<ProduitCommandeDTO> findByIdCommande(Short id) {
		return mapper.fromListEntity(repo.findByIdCommande(id));
	}

	@Override
	public List<ProduitCommandeDTO> addToCommand(Short id, List<ProduitCommandeDTO> dtos) {
		if (dtos.size() == 0) {
			return dtos;
		}
		
		Map<Short, ProduitCommandeEntity> dict = repo.findByIdCommande(id).stream().collect(Collectors.toMap(item -> item.getIdProduit(), item -> item));
		
		mapper.fromListDTO(dtos).stream()
		.forEach(item -> {
			Short idPrd = item.getIdProduit();
			ProduitCommandeEntity e = dict.get(idPrd);
			if (e != null) {
				e.setQuantite((short)(e.getQuantite() + item.getQuantite()));
				dict.put(idPrd, e);
			} else {
				item.setIdCommande(id);
				dict.put(idPrd, item);
			}
		});
		
		return mapper.fromListEntity(
				dict.values()
				.stream()
				.filter(item -> item.getId() != null || item.getQuantite() > 0)
				.map(entity -> {
					if (entity.getQuantite() <= 0) {
						repo.deleteById(entity.getId());
					} else {
						repo.save(entity);
					}
					
					return entity;
				})
				.filter(item -> item.getQuantite() > 0)
				.collect(Collectors.toList())
		);
	}
}
