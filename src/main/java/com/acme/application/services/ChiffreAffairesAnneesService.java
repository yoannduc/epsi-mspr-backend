package com.acme.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.acme.application.dtos.ChiffreAffairesAnneesDTO;
import com.acme.application.exceptions.ChiffreAffairesAnneesNotFoundException;

@Service
public interface ChiffreAffairesAnneesService {
	List<ChiffreAffairesAnneesDTO> getAll();
	ChiffreAffairesAnneesDTO findByAnnee(Short annee) throws ChiffreAffairesAnneesNotFoundException;
}
