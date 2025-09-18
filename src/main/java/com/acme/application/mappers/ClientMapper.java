package com.acme.application.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.acme.application.dtos.ClientDTO;
import com.acme.application.entities.ClientEntity;

@Service
public class ClientMapper {
	private ModelMapper modelMapper = new ModelMapper();
	
	public ClientDTO fromEntity(ClientEntity entity) {
		return modelMapper.map(entity, ClientDTO.class);
	}
	
	public ClientEntity fromDTO(ClientDTO dto) {
		return modelMapper.map(dto, ClientEntity.class);
	}
	
	public List<ClientDTO> fromListEntity(List<ClientEntity> entities) {
		return entities.stream().map(this::fromEntity).collect(Collectors.toList());
	}
	
	public List<ClientEntity> fromListDTO(List<ClientDTO> dtos) {
		return dtos.stream().map(this::fromDTO).collect(Collectors.toList());
	}
}
