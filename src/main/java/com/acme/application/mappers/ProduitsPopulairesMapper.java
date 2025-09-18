package com.acme.application.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.acme.application.dtos.ProduitsPopulairesDTO;
import com.acme.application.entities.ProduitsPopulairesEntity;

@Service
public class ProduitsPopulairesMapper {
	private ModelMapper modelMapper = new ModelMapper();
	
	public ProduitsPopulairesDTO fromEntity(ProduitsPopulairesEntity entity) {
		return modelMapper.map(entity, ProduitsPopulairesDTO.class);
	}
	
	public ProduitsPopulairesEntity fromDTO(ProduitsPopulairesDTO dto) {
		return modelMapper.map(dto, ProduitsPopulairesEntity.class);
	}
	
	public List<ProduitsPopulairesDTO> fromListEntity(List<ProduitsPopulairesEntity> entities) {
		return entities.stream().map(this::fromEntity).collect(Collectors.toList());
	}
	
	public List<ProduitsPopulairesEntity> fromListDTO(List<ProduitsPopulairesDTO> dtos) {
		return dtos.stream().map(this::fromDTO).collect(Collectors.toList());
	}
}
