package com.acme.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor @ToString @Builder
@Getter @Setter
public class ProduitsPopulairesDTO {
	private Short id;
	private String libelle;
	private String sku;
	private Short quantite;
}
