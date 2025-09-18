package com.acme.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.acme.application.dtos.ChiffreAffairesMoisDTO;
import com.acme.application.exceptions.ChiffreAffairesMoisNotFoundException;

@Service
public interface ChiffreAffairesMoisService {
	List<ChiffreAffairesMoisDTO> getAll();
	ChiffreAffairesMoisDTO findByMois(Short mois) throws ChiffreAffairesMoisNotFoundException;
}
