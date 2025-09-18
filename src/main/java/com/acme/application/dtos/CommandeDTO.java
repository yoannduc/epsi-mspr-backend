package com.acme.application.dtos;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor @ToString @Builder
@Getter @Setter
public class CommandeDTO {
	private Short id;
	private Short idClient;
	private LocalDateTime dateCreation;
	
	List<ProduitCommandeDTO> produits;
}
