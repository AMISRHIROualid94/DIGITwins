package com.sf.digitwins.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "employers")
public class Employer extends Person{


    public Employer(Long matricule, String nom, String prenom, LocalDateTime dateNaissance, SitFamill sitFamill, int nombreEnfant,String numCnss, Fonction fonction, LocalDateTime dateEmbauche, LocalDateTime dateSortie, int nombreCongePaye, int nombreRecuperation, int nombreReposTravaille) {
        super(matricule,nom,prenom,dateNaissance,sitFamill,nombreEnfant);
        this.numCnss = numCnss;
        this.fonction = fonction;
        this.dateEmbauche = dateEmbauche;
        this.dateSortie = dateSortie;
        this.nombreCongePaye = nombreCongePaye;
        this.nombreRecuperation = nombreRecuperation;
        this.nombreReposTravaille = nombreReposTravaille;
    }

    private String numCnss;
    private Fonction fonction;
    private LocalDateTime dateEmbauche;
    private LocalDateTime dateSortie;
    private int nombreCongePaye;
    private int nombreRecuperation;
    private int nombreReposTravaille;

}
