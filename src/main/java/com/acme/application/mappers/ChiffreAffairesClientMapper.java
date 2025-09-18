package com.acme.application.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.acme.application.dtos.ChiffreAffairesClientDTO;
import com.acme.application.entities.ChiffreAffairesClientEntity;

@Service
public class ChiffreAffairesClientMapper {
	private ModelMapper modelMapper = new ModelMapper();
	
	public ChiffreAffairesClientDTO fromEntity(ChiffreAffairesClientEntity entity) {
		return modelMapper.map(entity, ChiffreAffairesClientDTO.class);
	}
	
	public ChiffreAffairesClientEntity fromDTO(ChiffreAffairesClientDTO dto) {
		return modelMapper.map(dto, ChiffreAffairesClientEntity.class);
	}
	
	public List<ChiffreAffairesClientDTO> fromListEntity(List<ChiffreAffairesClientEntity> entities) {
		return entities.stream().map(this::fromEntity).collect(Collectors.toList());
	}
	
	public List<ChiffreAffairesClientEntity> fromListDTO(List<ChiffreAffairesClientDTO> dtos) {
		return dtos.stream().map(this::fromDTO).collect(Collectors.toList());
	}
}
