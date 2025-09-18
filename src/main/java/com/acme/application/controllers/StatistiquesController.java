package com.acme.application.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acme.application.dtos.ChiffreAffairesAnneesDTO;
import com.acme.application.dtos.ChiffreAffairesClientDTO;
import com.acme.application.dtos.ChiffreAffairesMoisDTO;
import com.acme.application.dtos.ChiffreAffairesTotalDTO;
import com.acme.application.dtos.ProduitsNonPopulairesDTO;
import com.acme.application.dtos.ProduitsPopulairesDTO;
import com.acme.application.services.ChiffreAffairesAnneesService;
import com.acme.application.services.ChiffreAffairesClientService;
import com.acme.application.services.ChiffreAffairesMoisService;
import com.acme.application.services.ChiffreAffairesTotalService;
import com.acme.application.services.ProduitsNonPopulairesService;
import com.acme.application.services.ProduitsPopulairesService;

@RestController
@RequestMapping("/api/v1")
public class StatistiquesController {
	private ChiffreAffairesTotalService catSrv;
	private ChiffreAffairesAnneesService caaSrv;
	private ChiffreAffairesMoisService camSrv;
	private ChiffreAffairesClientService cacSrv;
	private ProduitsPopulairesService ppSrv;
	private ProduitsNonPopulairesService pnpSrv;

	public StatistiquesController(ChiffreAffairesTotalService catSrv, ChiffreAffairesAnneesService caaSrv,
			ChiffreAffairesMoisService camSrv, ChiffreAffairesClientService cacSrv, ProduitsPopulairesService ppSrv,
			ProduitsNonPopulairesService pnpSrv) {
		super();
		this.catSrv = catSrv;
		this.caaSrv = caaSrv;
		this.camSrv = camSrv;
		this.cacSrv = cacSrv;
		this.ppSrv = ppSrv;
		this.pnpSrv = pnpSrv;
	}

	@GetMapping("/stats/ca/total")
	public ChiffreAffairesTotalDTO getCATotal() {
		return catSrv.get();
	}
	
	@GetMapping("/stats/ca/annees")
	public List<ChiffreAffairesAnneesDTO> getCAAnneesAll() {
		return caaSrv.getAll();
	}
	
	@GetMapping("/stats/ca/annees/{annee}")
	public ChiffreAffairesAnneesDTO getCAAnneesByAnnee(@PathVariable Short annee) {
		return caaSrv.findByAnnee(annee);
	}
	
	@GetMapping("/stats/ca/mois")
	public List<ChiffreAffairesMoisDTO> getCAMoisAll() {
		return camSrv.getAll();
	}
	
	@GetMapping("/stats/ca/mois/{mois}")
	public ChiffreAffairesMoisDTO getCAMoisByMois(@PathVariable Short mois) {
		return camSrv.findByMois(mois);
	}
	
	@GetMapping("/stats/ca/clients")
	public List<ChiffreAffairesClientDTO> getCAClientAll() {
		return cacSrv.getAll();
	}
	
	@GetMapping("/stats/ca/clients/{id}")
	public ChiffreAffairesClientDTO getCAClientById(@PathVariable Short id) {
		return cacSrv.findByClientId(id);
	}
	
	@GetMapping("/stats/produits/populaires")
	public List<ProduitsPopulairesDTO> getProduitsPopulaires() {
		return ppSrv.getAll();
	}
	
	@GetMapping("/stats/produits/non-populaires")
	public List<ProduitsNonPopulairesDTO> getProduitsNonPopulaires() {
		return pnpSrv.getAll();
	}
}
