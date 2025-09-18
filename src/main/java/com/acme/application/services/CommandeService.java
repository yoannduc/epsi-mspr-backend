package com.acme.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.acme.application.dtos.CommandeDTO;
import com.acme.application.dtos.ProduitCommandeDTO;
import com.acme.application.exceptions.CommandeNotFoundException;

@Service
public interface CommandeService {
	List<CommandeDTO> findByClientId(Short id);
	List<CommandeDTO> findByClientNom(String nom);
	CommandeDTO findById(Short id) throws CommandeNotFoundException;
	
	CommandeDTO saveNew(CommandeDTO dto);
	CommandeDTO addProductsToCommand(Short id, List<ProduitCommandeDTO> dtos) throws CommandeNotFoundException; 
}
