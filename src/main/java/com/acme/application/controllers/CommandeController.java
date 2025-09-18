package com.acme.application.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acme.application.dtos.CommandeDTO;
import com.acme.application.dtos.ProduitCommandeDTO;
import com.acme.application.services.CommandeService;

@RestController
@RequestMapping("/api/v1")
public class CommandeController {
	private CommandeService srv;

	public CommandeController(CommandeService srv) {
		super();
		this.srv = srv;
	}
	
	@GetMapping("/commandes/clients/{id}")
	public List<CommandeDTO> findByClientId(@PathVariable Short id) {
		return srv.findByClientId(id);
	}
	
	@GetMapping("/commandes/clients/name/{name}")
	public List<CommandeDTO> findByClientNom(@PathVariable String name) {
		return srv.findByClientNom(name);
	}
	
	@GetMapping("/commandes/{id}")
	public CommandeDTO findById(@PathVariable Short id) {
		return srv.findById(id);
	}
	
	@PostMapping(value="/commandes", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public CommandeDTO saveNew(@RequestBody CommandeDTO dto) {
		return srv.saveNew(dto);
	}
	
	@PostMapping(value="/commandes/{id}/produits", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public CommandeDTO addProducts(@PathVariable Short id, @RequestBody List<ProduitCommandeDTO> dtos) {
		return srv.addProductsToCommand(id, dtos);
	}
}
