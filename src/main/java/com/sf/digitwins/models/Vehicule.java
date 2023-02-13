package com.sf.digitwins.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "vehicules")
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long veh_matricule;
    private String numParc;
    private String type;
    private String plaquetteMatricule;
    private String marque;
    private String numerChassis;
    private LocalDate dateMiseEnCirculation;
    private LocalDate dateFinAssurance;
    private LocalDate dateFinVisiteTechnique;

    private String ChauffeurNom;
    private int nombrePneus;
    private String typePneus;
}
