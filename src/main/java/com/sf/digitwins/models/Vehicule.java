package com.sf.digitwins.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    //private Employer chauffeur;

    private int nombrePneus;
    private String typePneus;
}
