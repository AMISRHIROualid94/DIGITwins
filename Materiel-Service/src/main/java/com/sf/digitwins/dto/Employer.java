package com.sf.digitwins.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends Person{


    public Employer(Long matricule, String nom, String prenom, LocalDate dateNaissance, SitFamill sitFamilial, int nombreEnfant, String numCnss, Fonction fonction, LocalDate dateEmbauche, LocalDate dateSortie, int nombreCongePaye, int nombreRecuperation, int nombreReposTravaille) {
        super(matricule,nom,prenom,dateNaissance,sitFamilial,nombreEnfant);
        this.numCnss = numCnss;
        this.fonction = fonction;
        this.dateEmbauche = dateEmbauche;
        this.dateSortie = dateSortie;
        this.nombreCongePaye = nombreCongePaye;
        this.nombreRecuperation = nombreRecuperation;
        this.nombreReposTravaille = nombreReposTravaille;
    }

    private String numCnss;

    @Enumerated(EnumType.STRING)
    private Fonction fonction;
    private LocalDate dateEmbauche;
    private LocalDate dateSortie;
    private int nombreCongePaye;
    private int nombreRecuperation;
    private int nombreReposTravaille;



}
