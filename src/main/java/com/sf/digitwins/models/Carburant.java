package com.sf.digitwins.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "carburants")
public class Carburant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carb_matricule;
    private String type; // nous pouvons avoir besoin d'une Enumeration des type (ex: 10w40, e5...)
    private Double quantiteConsommee;
    private Double prixUnit;
    private LocalDate dateConsomation;

    @OneToOne
    @JoinColumn(name = "Veh_matricule")
    private Vehicule vehicule ;


}
