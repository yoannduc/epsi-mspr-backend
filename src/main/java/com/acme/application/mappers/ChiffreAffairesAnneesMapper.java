package com.acme.application.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.acme.application.dtos.ChiffreAffairesAnneesDTO;
import com.acme.application.entities.ChiffreAffairesAnneesEntity;

@Service
public class ChiffreAffairesAnneesMapper {
	private ModelMapper modelMapper = new ModelMapper();
	
	public ChiffreAffairesAnneesDTO fromEntity(ChiffreAffairesAnneesEntity entity) {
		return modelMapper.map(entity, ChiffreAffairesAnneesDTO.class);
	}
	
	public ChiffreAffairesAnneesEntity fromDTO(ChiffreAffairesAnneesDTO dto) {
		return modelMapper.map(dto, ChiffreAffairesAnneesEntity.class);
	}
	
	public List<ChiffreAffairesAnneesDTO> fromListEntity(List<ChiffreAffairesAnneesEntity> entities) {
		return entities.stream().map(this::fromEntity).collect(Collectors.toList());
	}
	
	public List<ChiffreAffairesAnneesEntity> fromListDTO(List<ChiffreAffairesAnneesDTO> dtos) {
		return dtos.stream().map(this::fromDTO).collect(Collectors.toList());
	}
}
