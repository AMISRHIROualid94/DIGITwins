package com.sf.digitwins.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "petit_materiel")
public class PetitMateriel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matricule;
    private TypeMateriel typeMateriel;
    private int quantite;
    private int quantiteResante;
    private LocalDateTime dateEntre;
    private LocalDateTime dateSortie;

}
