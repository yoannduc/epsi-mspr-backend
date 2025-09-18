package com.acme.application.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.acme.application.dtos.CommandeDTO;
import com.acme.application.dtos.ProduitCommandeDTO;
import com.acme.application.entities.CommandeEntity;
import com.acme.application.exceptions.CommandeNotFoundException;
import com.acme.application.mappers.CommandeMapper;
import com.acme.application.mappers.ProduitCommandeMapper;
import com.acme.application.repositories.ClientRepository;
import com.acme.application.repositories.CommandeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommandeServiceImpl implements CommandeService {
	private CommandeRepository repo;
	private CommandeMapper mapper;
	private ClientRepository clientRepo;
	
	private ProduitCommandeService produitCommandeSrv;
	private ProduitCommandeMapper produitCommandeMapper;

	public CommandeServiceImpl(CommandeRepository repo, CommandeMapper mapper, ClientRepository clientRepo, ProduitCommandeService produitCommandeSrv, ProduitCommandeMapper produitCommandeMapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
		this.clientRepo = clientRepo;
		this.produitCommandeSrv = produitCommandeSrv;
		this.produitCommandeMapper = produitCommandeMapper;
	}

	@Override
	public List<CommandeDTO> findByClientId(Short id) {
		return mapper.fromListEntity(
				repo.findByIdClient(id).stream()
				.map(entity -> {
					List<ProduitCommandeDTO> prds = produitCommandeSrv.findByIdCommande(entity.getId());
					
					entity.setProduits(produitCommandeMapper.fromListDTO(prds));
					
					return entity;
				})
				.collect(Collectors.toList())
		);
	}
	
	@Override
	public List<CommandeDTO> findByClientNom(String nom) {
		return mapper.fromListEntity(
				repo.findByIdClientIn(
						clientRepo.findByNom(nom).stream()
						.map(el -> el.getId())
						.collect(Collectors.toList())
				).stream()
				.map(entity -> {
					List<ProduitCommandeDTO> prds = produitCommandeSrv.findByIdCommande(entity.getId());
					
					entity.setProduits(produitCommandeMapper.fromListDTO(prds));
					
					return entity;
				})
				.collect(Collectors.toList())
		);
	}

	@Override
	public CommandeDTO findById(Short id) {
		Optional<CommandeEntity> entity = repo.findById(id);
		if (entity.isEmpty()) {
			throw new CommandeNotFoundException();
		}
		
		List<ProduitCommandeDTO> prds = produitCommandeSrv.findByIdCommande(id);
		
		entity.get().setProduits(produitCommandeMapper.fromListDTO(prds));
		
		return mapper.fromEntity(entity.get());
	}

	@Override
	public CommandeDTO saveNew(CommandeDTO dto) {
		CommandeEntity entity = mapper.fromDTO(dto);
		entity.setDateCreation(LocalDateTime.now());
		
		return mapper.fromEntity(repo.save(entity));
	}

	@Override
	public CommandeDTO addProductsToCommand(Short id, List<ProduitCommandeDTO> dtos) throws CommandeNotFoundException {
		Optional<CommandeEntity> entity = repo.findById(id);
		if (entity.isEmpty()) {
			throw new CommandeNotFoundException();
		}
		
		List<ProduitCommandeDTO> newPrds = produitCommandeSrv.addToCommand(id, dtos);
		
		entity.get().setProduits(produitCommandeMapper.fromListDTO(newPrds));
		
		return mapper.fromEntity(entity.get());
	}
	
	
}
