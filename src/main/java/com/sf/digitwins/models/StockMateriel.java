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
@Table(name = "Stock_materiel")
public class StockMateriel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stock_matricule;

    @Enumerated(EnumType.STRING)
    private TypeMateriel typeMateriel;
    private int quantiteInitiale;
    private LocalDate dateSortie;

}
