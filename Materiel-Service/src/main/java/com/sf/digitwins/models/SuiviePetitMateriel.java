package com.sf.digitwins.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "suivie_petit_materiel")
public class SuiviePetitMateriel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pm_matricule;

    @Enumerated(EnumType.STRING)
    private TypeMateriel typeMateriel;
    private int quantite;
    private int quantiteResante;
    private LocalDate dateSortie;

    private String ouvrierNom;
    private String vehiculeNumParc;


}
