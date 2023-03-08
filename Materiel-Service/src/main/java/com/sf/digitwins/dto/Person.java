package com.sf.digitwins.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person implements Serializable {

    private Long matricule;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    @Enumerated(EnumType.STRING)
    private SitFamill sitFamilial;
    private int nombreEnfant;

}
