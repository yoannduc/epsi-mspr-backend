package com.acme.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.acme.application.dtos.ProduitDTO;
import com.acme.application.exceptions.ProduitNotFoundException;
import com.acme.application.exceptions.ProduitSkuAlreadyExistsException;

@Service
public interface ProduitService {
	List<ProduitDTO> getAll();
	List<ProduitDTO> findByCategorie(String categorie);
	ProduitDTO findById(Short id) throws ProduitNotFoundException;
	
	ProduitDTO saveNew(ProduitDTO dto) throws ProduitSkuAlreadyExistsException;
	ProduitDTO update(Short id, ProduitDTO dto) throws ProduitNotFoundException;
	ProduitDTO delete(Short id) throws ProduitNotFoundException;
}
