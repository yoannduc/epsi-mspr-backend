package com.acme.application.services;

import org.springframework.stereotype.Service;

import com.acme.application.dtos.ChiffreAffairesTotalDTO;

@Service
public interface ChiffreAffairesTotalService {
	ChiffreAffairesTotalDTO get();
}
