package com.acme.application.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "commande")
@Data @NoArgsConstructor @AllArgsConstructor @ToString @Builder
@Getter @Setter
public class CommandeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	private LocalDateTime dateCreation;
	
	private Short idClient;
	
	@Transient
	List<ProduitCommandeEntity> produits;
}