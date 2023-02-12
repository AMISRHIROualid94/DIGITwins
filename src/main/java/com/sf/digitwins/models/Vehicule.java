package com.sf.digitwins.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "vehicules")
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matricule;
    private String numParc;
    private String plaquetteMatricule;
    private String marque;
    private String numerChassis;
    private LocalDateTime dateMiseEnCirculation;
    private LocalDateTime dateAssurance;
    private LocalDateTime dateVisiteTechnique;

    @OneToOne
    @JoinColumn(name = "Chauffeur_id")
    private Employer chauffeur;


    private int nombrePneus;
    private String typePneus;
}
