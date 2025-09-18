package com.acme.application.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.acme.application.dtos.ProduitCommandeDTO;
import com.acme.application.entities.ProduitCommandeEntity;

@Service
public class ProduitCommandeMapper {
	private ModelMapper modelMapper = new ModelMapper();
	
	public ProduitCommandeDTO fromEntity(ProduitCommandeEntity entity) {
		return modelMapper.map(entity, ProduitCommandeDTO.class);
	}
	
	public ProduitCommandeEntity fromDTO(ProduitCommandeDTO dto) {
		return modelMapper.map(dto, ProduitCommandeEntity.class);
	}
	
	public List<ProduitCommandeDTO> fromListEntity(List<ProduitCommandeEntity> entities) {
		return entities.stream().map(this::fromEntity).collect(Collectors.toList());
	}
	
	public List<ProduitCommandeEntity> fromListDTO(List<ProduitCommandeDTO> dtos) {
		return dtos.stream().map(this::fromDTO).collect(Collectors.toList());
	}
}
