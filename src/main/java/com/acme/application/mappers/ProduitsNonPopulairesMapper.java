package com.acme.application.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.acme.application.dtos.ProduitsNonPopulairesDTO;
import com.acme.application.entities.ProduitsNonPopulairesEntity;

@Service
public class ProduitsNonPopulairesMapper {
	private ModelMapper modelMapper = new ModelMapper();
	
	public ProduitsNonPopulairesDTO fromEntity(ProduitsNonPopulairesEntity entity) {
		return modelMapper.map(entity, ProduitsNonPopulairesDTO.class);
	}
	
	public ProduitsNonPopulairesEntity fromDTO(ProduitsNonPopulairesDTO dto) {
		return modelMapper.map(dto, ProduitsNonPopulairesEntity.class);
	}
	
	public List<ProduitsNonPopulairesDTO> fromListEntity(List<ProduitsNonPopulairesEntity> entities) {
		return entities.stream().map(this::fromEntity).collect(Collectors.toList());
	}
	
	public List<ProduitsNonPopulairesEntity> fromListDTO(List<ProduitsNonPopulairesDTO> dtos) {
		return dtos.stream().map(this::fromDTO).collect(Collectors.toList());
	}
}
