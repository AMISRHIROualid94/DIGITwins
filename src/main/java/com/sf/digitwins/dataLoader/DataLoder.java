package com.sf.digitwins.dataLoader;

import com.sf.digitwins.models.*;
import com.sf.digitwins.repositories.SuiviePetitMaterielRepository;
import com.sf.digitwins.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoder implements CommandLineRunner {

    @Autowired
    private EmployerService employerService;
    @Autowired
    private VehiculeService vehiculeService;

    @Autowired
    private StockMaterielService stockMaterielService;

    @Autowired
    private SuiviePetitMaterielService suiviePetitMaterielService;

    @Autowired
    private CarburantService carburantService;
    @Autowired
    private SuiviePetitMaterielRepository suiviePetitMaterielRepository;

    @Override
    public void run(String... args) throws Exception {


        Employer employer1 = new Employer();
        Employer employer2 = new Employer();
        Employer employer3 = new Employer();
        Carburant carburant1 = new Carburant();
        Carburant carburant2 = new Carburant();
        StockMateriel stockMateriel1 = new StockMateriel();
        StockMateriel stockMateriel2 = new StockMateriel();
        SuiviePetitMateriel suiviePetitMateriel1 = new SuiviePetitMateriel();
        SuiviePetitMateriel suiviePetitMateriel2 = new SuiviePetitMateriel();
        Vehicule vehicule1 = new Vehicule();
        Vehicule vehicule2 = new Vehicule();

        //Ajouter des Employers - debut

        employer1.setNom("employer1 nom");
        employer1.setPrenom("employer1 prénom");
        employer1.setDateNaissance(LocalDate.parse("1994-02-14"));
        employer1.setSitFamilial(SitFamill.CELIBATAIRE.toString());
        employer1.setNumCnss("123456783");
        employer1.setFonction(Fonction.BALAYEUR.toString());
        employer1.setDateEmbauche(LocalDate.parse("2023-02-14"));
        employer1.setNombreCongePaye(0);
        employer1.setNombreRecuperation(0);
        employer1.setNombreReposTravaille(0);

        employerService.save(employer1);

        employer2.setNom("employer2 nom");
        employer2.setPrenom("employer2 prénom");
        employer2.setDateNaissance(LocalDate.parse("1990-11-10"));
        employer2.setSitFamilial(SitFamill.MARRIE.toString());
        employer2.setNombreEnfant(2);
        employer2.setNumCnss("123456783");
        employer2.setFonction(Fonction.CHAUFFEUR.toString());
        employer2.setDateEmbauche(LocalDate.parse("2023-02-12"));
        employer2.setNombreCongePaye(0);
        employer2.setNombreRecuperation(0);
        employer2.setNombreReposTravaille(0);

        employerService.save(employer2);

        employer3.setNom("employer2 nom");
        employer3.setPrenom("employer2 prénom");
        employer3.setDateNaissance(LocalDate.parse("1989-11-10"));
        employer3.setSitFamilial(SitFamill.MARRIE.toString());
        employer3.setNombreEnfant(1);
        employer3.setNumCnss("123456783");
        employer3.setFonction(Fonction.CHAUFFEUR.toString());
        employer3.setDateEmbauche(LocalDate.parse("2023-02-12"));
        employer3.setNombreCongePaye(0);
        employer3.setNombreRecuperation(0);
        employer3.setNombreReposTravaille(0);

        employerService.save(employer3);
        //Ajouter des Employers - fin

        //Ajouter des Véhicules - debut
        vehicule1.setNumParc("2500");
        vehicule1.setType("Camion");
        vehicule1.setPlaquetteMatricule("72166-H-6");
        vehicule1.setMarque("Mercedes");
        vehicule1.setNumerChassis("AB53738VD23");
        vehicule1.setDateMiseEnCirculation(LocalDate.parse("2015-06-22"));
        vehicule1.setDateFinAssurance(LocalDate.parse("2023-05-20"));
        vehicule1.setDateFinVisiteTechnique(LocalDate.parse("2023-10-22"));
        vehicule1.setChauffeur(employer2);
        vehicule1.setNombrePneus(8);
        vehicule1.setTypePneus("17R");

        vehiculeService.save(vehicule1);

        vehicule2.setNumParc("2502");
        vehicule2.setType("min-tp");
        vehicule2.setPlaquetteMatricule("72162-H-6");
        vehicule2.setMarque("Futon");
        vehicule2.setNumerChassis("AB78738VD23");
        vehicule2.setDateMiseEnCirculation(LocalDate.parse("2015-06-22"));
        vehicule2.setDateFinAssurance(LocalDate.parse("2023-05-20"));
        vehicule2.setDateFinVisiteTechnique(LocalDate.parse("2023-10-22"));
        vehicule2.setChauffeur(employer3);
        vehicule2.setNombrePneus(8);
        vehicule2.setTypePneus("16R");

        vehiculeService.save(vehicule2);
        //Ajouter des Véhicules - fin

        //Ajouter des Stocks - debut
        stockMateriel1.setTypeMateriel(TypeMateriel.BALAIS.toString());
        stockMateriel1.setQuantiteInitiale(30);
        stockMateriel1.setDateSortie(LocalDate.parse("2023-02-11"));

        stockMaterielService.save(stockMateriel1);

        stockMateriel2.setTypeMateriel(TypeMateriel.PELL.toString());
        stockMateriel2.setQuantiteInitiale(30);
        stockMateriel2.setDateSortie(LocalDate.parse("2023-02-11"));

        stockMaterielService.save(stockMateriel2);
        //Ajouter des Stocks - fin




        //Ajouter des suivies des PetitMateriel - debut
        suiviePetitMateriel1.setTypeMateriel(TypeMateriel.BALAIS.toString());
        suiviePetitMateriel1.setQuantite(1);
        int qSortie = suiviePetitMateriel1.getQuantite();
        String typeMateriel = suiviePetitMateriel1.getTypeMateriel();
        int qStock = stockMaterielService.findByTypeMateriel(typeMateriel);
        StockMateriel stockMateriel = stockMaterielService.findByTypeMaterielObject(typeMateriel);
        int qResante = qStock - qSortie;
        suiviePetitMateriel1.setQuantiteResante(qResante);
        stockMateriel.setQuantiteInitiale(qResante);
        stockMateriel.setStock_matricule(stockMateriel.getStock_matricule());
        suiviePetitMateriel1.setDateSortie(LocalDate.parse("2023-01-22"));
        suiviePetitMateriel1.setOuvrier(employer1);
        suiviePetitMateriel1.setVehicule(null);
        suiviePetitMaterielRepository.save(suiviePetitMateriel1);

        stockMateriel.setStock_matricule(stockMateriel.getStock_matricule());
        stockMaterielService.save(stockMateriel);





    }
}