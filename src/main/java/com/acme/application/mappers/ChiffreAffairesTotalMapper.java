package com.acme.application.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.acme.application.dtos.ChiffreAffairesTotalDTO;
import com.acme.application.entities.ChiffreAffairesTotalEntity;

@Service
public class ChiffreAffairesTotalMapper {
	private ModelMapper modelMapper = new ModelMapper();
	
	public ChiffreAffairesTotalDTO fromEntity(ChiffreAffairesTotalEntity entity) {
		return modelMapper.map(entity, ChiffreAffairesTotalDTO.class);
	}
	
	public ChiffreAffairesTotalEntity fromDTO(ChiffreAffairesTotalDTO dto) {
		return modelMapper.map(dto, ChiffreAffairesTotalEntity.class);
	}
	
	public List<ChiffreAffairesTotalDTO> fromListEntity(List<ChiffreAffairesTotalEntity> entities) {
		return entities.stream().map(this::fromEntity).collect(Collectors.toList());
	}
	
	public List<ChiffreAffairesTotalEntity> fromListDTO(List<ChiffreAffairesTotalDTO> dtos) {
		return dtos.stream().map(this::fromDTO).collect(Collectors.toList());
	}
}
