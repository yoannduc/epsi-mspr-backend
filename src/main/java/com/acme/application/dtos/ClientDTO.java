package com.acme.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor @ToString @Builder
@Getter @Setter
public class ClientDTO {
	private Short id;
	private String prenom;
	private String nom;
	private String telephone;
	private String mail;
	private Short numAddr;
	private String modNumAddr;
	private String rueAddr;
	private String codePostalAddr;
	private String villeAddr;
}
