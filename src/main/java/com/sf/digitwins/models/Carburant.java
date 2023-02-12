package com.sf.digitwins.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "carburant")
public class Carburant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matricule;
    private String type; // nous pouvons avoir besoin d'une Enumeration des type (ex: 10w40, e5...)
    private Double quantiteConsommee;
    private Double prixUnit;
    private LocalDateTime dateConsomation;
    //private List<Vehicule> vehicules = new HashSet<>();


}
