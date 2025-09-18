package com.acme.application.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.acme.application.dtos.ProduitDTO;
import com.acme.application.entities.ProduitEntity;

@Service
public class ProduitMapper {
	private ModelMapper modelMapper = new ModelMapper();
	
	public ProduitDTO fromEntity(ProduitEntity entity) {
		return modelMapper.map(entity, ProduitDTO.class);
	}
	
	public ProduitEntity fromDTO(ProduitDTO dto) {
		return modelMapper.map(dto, ProduitEntity.class);
	}
	
	public List<ProduitDTO> fromListEntity(List<ProduitEntity> entities) {
		return entities.stream().map(this::fromEntity).collect(Collectors.toList());
	}
	
	public List<ProduitEntity> fromListDTO(List<ProduitDTO> dtos) {
		return dtos.stream().map(this::fromDTO).collect(Collectors.toList());
	}
}
