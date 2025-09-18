package com.acme.application.entities;

import jakarta.persistence.Entity;
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
@Table(name = "chiffre_affaires_annee")
@Data @NoArgsConstructor @AllArgsConstructor @ToString @Builder
@Getter @Setter
public class ChiffreAffairesAnneesEntity {
	@Id
	private Short annee;
	private Short chiffreAffaire;
}
