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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "employer_materiels",
          joinColumns = @JoinColumn(name = "Employer_matricule"),
            inverseJoinColumns = @JoinColumn(name = "materiel_matricule"))
    private Employer ouvrier;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "vehicule_materiels",
            joinColumns = @JoinColumn(name = "vehicule_matricule"),
            inverseJoinColumns = @JoinColumn(name = "materiel_matricule"))
    private Vehicule vehicule;
   /* public void SetEmployer(Employer ouvrier){
        if(ouvrier !=null){
            this.ouvrier = ouvrier;
        }
    }*/

}
