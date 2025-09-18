package com.acme.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.acme.application.dtos.ProduitsPopulairesDTO;

@Service
public interface ProduitsPopulairesService {
	List<ProduitsPopulairesDTO> getAll();
}
