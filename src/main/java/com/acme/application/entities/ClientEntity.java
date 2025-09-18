package com.acme.application.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "client")
@Data @NoArgsConstructor @AllArgsConstructor @ToString @Builder
@Getter @Setter
public class ClientEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	private String prenom;
	private String nom;
	@Column(name = "numero_tel")
	private String telephone;
	private String mail;
	private Short numAddr;
	private String modNumAddr;
	private String rueAddr;
	private String codePostalAddr;
	private String villeAddr;
}

