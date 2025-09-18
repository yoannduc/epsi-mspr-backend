package com.acme.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.acme.application.dtos.ProduitCommandeDTO;
import com.acme.application.exceptions.ProduitCommandeNotFoundException;

@Service
public interface ProduitCommandeService {
	ProduitCommandeDTO findById(Short id) throws ProduitCommandeNotFoundException;
	List<ProduitCommandeDTO> findByIdCommande(Short id);
	List<ProduitCommandeDTO> addToCommand(Short id, List<ProduitCommandeDTO> dtos);
}
