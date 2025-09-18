package com.acme.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor @ToString @Builder
@Getter @Setter
public class ProduitCommandeDTO {
	private Short id;	
	private Short idCommande;
	private Short idProduit;
	private Short quantite;
}
