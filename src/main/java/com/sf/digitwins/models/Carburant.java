package com.sf.digitwins.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "carburants")
public class Carburant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matricule;
    private String type; // nous pouvons avoir besoin d'une Enumeration des type (ex: 10w40, e5...)
    private Double quantiteConsommee;
    private Double prixUnit;
    private LocalDateTime dateConsomation;

    @OneToOne
    @JoinColumn(name = "Veh_matricule")
    private Vehicule vehicule ;


}
