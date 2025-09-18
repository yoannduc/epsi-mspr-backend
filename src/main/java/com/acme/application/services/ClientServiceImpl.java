package com.acme.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.acme.application.dtos.ClientDTO;
import com.acme.application.entities.ClientEntity;
import com.acme.application.exceptions.ClientMailAlreadyExistsException;
import com.acme.application.exceptions.ClientNotFoundException;
import com.acme.application.mappers.ClientMapper;
import com.acme.application.objectmerger.ObjectMerger;
import com.acme.application.repositories.ClientRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService {
	private ClientRepository repo;
	private ClientMapper mapper;
	
	public ClientServiceImpl(ClientRepository repo, ClientMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	@Override
	public List<ClientDTO> getAll() {
		return mapper.fromListEntity(repo.findAll());
	}

	@Override
	public List<ClientDTO> findByVilleAddr(String ville) {
		return mapper.fromListEntity(repo.findByVilleAddr(ville));
	}

	@Override
	public List<ClientDTO> findByCodePostalAddr(String codePostal) {
		return mapper.fromListEntity(repo.findByCodePostalAddr(codePostal));
	}

	@Override
	public List<ClientDTO> findByNom(String nom) {
		return mapper.fromListEntity(repo.findByNom(nom));
	}

	@Override
	public List<ClientDTO> findByMailContaining(String mail) {
		return mapper.fromListEntity(repo.findByMailContaining(mail));
	}

	@Override
	public ClientDTO findById(Short id) throws ClientNotFoundException {
		Optional<ClientEntity> entity = repo.findById(id);
		if (entity.isEmpty()) {
			throw new ClientNotFoundException();
		}
		return mapper.fromEntity(entity.get());
	}

	@Override
	public ClientDTO findByMail(String mail) throws ClientNotFoundException {
		Optional<ClientEntity> entity = repo.findByMail(mail);
		if (entity.isEmpty()) {
			throw new ClientNotFoundException();
		}
		return mapper.fromEntity(entity.get());
	}
	
	@Override
	public ClientDTO saveNew(ClientDTO dto) throws ClientMailAlreadyExistsException {
		if (repo.existsByMail(dto.getMail())) {
			throw new ClientMailAlreadyExistsException();
		}
		
		return mapper.fromEntity(repo.save(mapper.fromDTO(dto)));
	}
	
	@Override
	public ClientDTO update(Short id, ClientDTO dto) throws ClientNotFoundException {
		Optional<ClientEntity> entity = repo.findById(id);
		if (entity.isEmpty()) {
			throw new ClientNotFoundException();
		}
		
		ClientEntity inputEntity = mapper.fromDTO(dto);
		inputEntity.setId(null);
		
		return mapper.fromEntity(repo.save(ObjectMerger.merge(inputEntity, entity.get())));
	}
	
	@Override
	public ClientDTO delete(Short id) throws ClientNotFoundException {
		Optional<ClientEntity> entity = repo.findById(id);
		if (entity.isEmpty()) {
			throw new ClientNotFoundException();
		}
		
		repo.deleteById(id);
		return mapper.fromEntity(entity.get());
	}
}
