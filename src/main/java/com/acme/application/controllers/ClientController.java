package com.acme.application.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acme.application.dtos.ClientDTO;
import com.acme.application.services.ClientService;

@RestController
@RequestMapping("/api/v1")
public class ClientController {
	private ClientService srv;

	public ClientController(ClientService srv) {
		super();
		this.srv = srv;
	}
	
	@GetMapping("/clients")
	public List<ClientDTO> getAll() {
		return srv.getAll();
	}
	
	@GetMapping("/clients/{id}")
	public ClientDTO findById(@PathVariable Short id) {
		return srv.findById(id);
	}
	
	@DeleteMapping(value="/clients/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ClientDTO delete(@PathVariable Short id) {
		return srv.delete(id);
	}
	
	@PutMapping(value="/clients/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ClientDTO update(@PathVariable Short id, @RequestBody ClientDTO dto) {
		return srv.update(id, dto);
	}
	
	@PostMapping(value="/clients", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ClientDTO saveNew(@RequestBody ClientDTO dto) {
		return srv.saveNew(dto);
	}
}
