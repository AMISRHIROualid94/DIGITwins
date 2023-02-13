package com.sf.digitwins.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "employers")
public class Employer extends Person{


    public Employer(Long matricule, String nom, String prenom, LocalDate dateNaissance, String sitFamilial, int nombreEnfant,String numCnss, String fonction, LocalDate dateEmbauche, LocalDate dateSortie, int nombreCongePaye, int nombreRecuperation, int nombreReposTravaille) {
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
    private String fonction;
    private LocalDate dateEmbauche;
    private LocalDate dateSortie;
    private int nombreCongePaye;
    private int nombreRecuperation;
    private int nombreReposTravaille;


}
