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
@Table(name = "petit_materiel")
public class SuiviePetitMateriel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pm_matricule;
    private String typeMateriel;
    private int quantite;
    private int quantiteResante;
    private LocalDate dateSortie;

    @ManyToOne
    @JoinColumn(name = "Ouvrier_matricule")
    private Employer ouvrier;

    @ManyToOne
    @JoinColumn(name = "vehicule_matricule")
    private Vehicule vehicule;


}
