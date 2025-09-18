package com.acme.application.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.acme.application.dtos.ChiffreAffairesMoisDTO;
import com.acme.application.entities.ChiffreAffairesMoisEntity;

@Service
public class ChiffreAffairesMoisMapper {
	private ModelMapper modelMapper = new ModelMapper();
	
	public ChiffreAffairesMoisDTO fromEntity(ChiffreAffairesMoisEntity entity) {
		return modelMapper.map(entity, ChiffreAffairesMoisDTO.class);
	}
	
	public ChiffreAffairesMoisEntity fromDTO(ChiffreAffairesMoisDTO dto) {
		return modelMapper.map(dto, ChiffreAffairesMoisEntity.class);
	}
	
	public List<ChiffreAffairesMoisDTO> fromListEntity(List<ChiffreAffairesMoisEntity> entities) {
		return entities.stream().map(this::fromEntity).collect(Collectors.toList());
	}
	
	public List<ChiffreAffairesMoisEntity> fromListDTO(List<ChiffreAffairesMoisDTO> dtos) {
		return dtos.stream().map(this::fromDTO).collect(Collectors.toList());
	}
}
