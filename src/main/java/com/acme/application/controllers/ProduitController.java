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

import com.acme.application.dtos.ProduitDTO;
import com.acme.application.services.ProduitService;

@RestController
@RequestMapping("/api/v1")
public class ProduitController {
	private ProduitService srv;

	public ProduitController(ProduitService srv) {
		super();
		this.srv = srv;
	}
	
	@GetMapping("/produits")
	public List<ProduitDTO> getAll() {
		return srv.getAll();
	}
	
	@GetMapping("/produits/{id}")
	public ProduitDTO findById(@PathVariable Short id) {
		return srv.findById(id);
	}
	
	@DeleteMapping(value="/produits/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProduitDTO delete(@PathVariable Short id) {
		return srv.delete(id);
	}
	
	@PutMapping(value="/produits/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ProduitDTO update(@PathVariable Short id, @RequestBody ProduitDTO dto) {
		return srv.update(id, dto);
	}
	
	@PostMapping(value="/produits", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ProduitDTO saveNew(@RequestBody ProduitDTO dto) {
		return srv.saveNew(dto);
	}
}
