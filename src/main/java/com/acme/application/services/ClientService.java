package com.acme.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.acme.application.dtos.ClientDTO;
import com.acme.application.exceptions.ClientMailAlreadyExistsException;
import com.acme.application.exceptions.ClientNotFoundException;

@Service
public interface ClientService {
	List<ClientDTO> getAll();
	List<ClientDTO> findByVilleAddr(String ville);
	List<ClientDTO> findByCodePostalAddr(String codePostal);
	List<ClientDTO> findByNom(String nom);
	List<ClientDTO> findByMailContaining(String mail);
	ClientDTO findById(Short id) throws ClientNotFoundException;
	ClientDTO findByMail(String mail) throws ClientNotFoundException;
	
	ClientDTO saveNew(ClientDTO dto) throws ClientMailAlreadyExistsException;
	ClientDTO update(Short id, ClientDTO dto) throws ClientNotFoundException;
	ClientDTO delete(Short id) throws ClientNotFoundException;
}
