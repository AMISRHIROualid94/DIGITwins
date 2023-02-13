package com.sf.digitwins.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matricule;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String sitFamilial;
    private int nombreEnfant;

    public void setNombreEnfant(int nombreEnfant) {
        if (this.sitFamilial.equals(SitFamill.CELIBATAIRE.toString())){
            this.nombreEnfant = 0;
        }else{
            this.nombreEnfant = nombreEnfant;
        }

    }
}
