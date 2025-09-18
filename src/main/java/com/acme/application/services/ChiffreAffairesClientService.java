package com.acme.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.acme.application.dtos.ChiffreAffairesClientDTO;
import com.acme.application.exceptions.ChiffreAffairesClientNotFoundException;

@Service
public interface ChiffreAffairesClientService {
	List<ChiffreAffairesClientDTO> getAll();
	ChiffreAffairesClientDTO findByClientId(Short id) throws ChiffreAffairesClientNotFoundException;
}
