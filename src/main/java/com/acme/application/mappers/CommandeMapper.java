package com.acme.application.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.acme.application.dtos.CommandeDTO;
import com.acme.application.entities.CommandeEntity;

@Service
public class CommandeMapper {
	private ModelMapper modelMapper = new ModelMapper();
	
	public CommandeDTO fromEntity(CommandeEntity entity) {
		return modelMapper.map(entity, CommandeDTO.class);
	}
	
	public CommandeEntity fromDTO(CommandeDTO dto) {
		return modelMapper.map(dto, CommandeEntity.class);
	}
	
	public List<CommandeDTO> fromListEntity(List<CommandeEntity> entities) {
		return entities.stream().map(this::fromEntity).collect(Collectors.toList());
	}
	
	public List<CommandeEntity> fromListDTO(List<CommandeDTO> dtos) {
		return dtos.stream().map(this::fromDTO).collect(Collectors.toList());
	}
}
