package com.acme.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.acme.application.dtos.ProduitsNonPopulairesDTO;

@Service
public interface ProduitsNonPopulairesService {
	List<ProduitsNonPopulairesDTO> getAll();
}
