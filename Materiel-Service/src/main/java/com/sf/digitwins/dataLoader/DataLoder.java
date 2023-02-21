package com.sf.digitwins.dataLoader;

import com.sf.digitwins.models.*;
import com.sf.digitwins.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoder implements CommandLineRunner {


    private final VehiculeService vehiculeService;


    private final StockMaterielService stockMaterielService;


    private final SuiviePetitMaterielService suiviePetitMaterielService;


    private final CarburantService carburantService;


    public DataLoder(VehiculeService vehiculeService, StockMaterielService stockMaterielService, SuiviePetitMaterielService suiviePetitMaterielService, CarburantService carburantService) {
        this.vehiculeService = vehiculeService;
        this.stockMaterielService = stockMaterielService;
        this.suiviePetitMaterielService = suiviePetitMaterielService;
        this.carburantService = carburantService;
    }

    @Override
    public void run(String... args) {



        Carburant carburant1 = new Carburant();
        Carburant carburant2 = new Carburant();
        StockMateriel stockMateriel1 = new StockMateriel();
        StockMateriel stockMateriel2 = new StockMateriel();
        SuiviePetitMateriel suiviePetitMateriel1 = new SuiviePetitMateriel();
        SuiviePetitMateriel suiviePetitMateriel2 = new SuiviePetitMateriel();
        Vehicule vehicule1 = new Vehicule();
        Vehicule vehicule2 = new Vehicule();


        //Ajouter des Véhicules - debut
        vehicule1.setNumParc("2500");
        vehicule1.setType("Camion");
        vehicule1.setPlaquetteMatricule("72166-H-6");
        vehicule1.setMarque("Mercedes");
        vehicule1.setNumerChassis("AB53738VD23");
        vehicule1.setDateMiseEnCirculation(LocalDate.parse("2015-06-22"));
        vehicule1.setDateFinAssurance(LocalDate.parse("2023-05-20"));
        vehicule1.setDateFinVisiteTechnique(LocalDate.parse("2023-10-22"));
        vehicule1.setChauffeurNom(null);
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
        vehicule2.setChauffeurNom(null);
        vehicule2.setNombrePneus(6);
        vehicule2.setTypePneus("16R");

        vehiculeService.save(vehicule2);
        //Ajouter des Véhicules - fin

        //Ajouter des Stocks - debut
        stockMateriel1.setTypeMateriel(TypeMateriel.BALAIS);
        stockMateriel1.setQuantiteInitiale(30);
        stockMateriel1.setDateSortie(LocalDate.parse("2023-02-11"));

        stockMaterielService.save(stockMateriel1);

        stockMateriel2.setTypeMateriel(TypeMateriel.PELL);
        stockMateriel2.setQuantiteInitiale(30);
        stockMateriel2.setDateSortie(LocalDate.parse("2023-02-11"));

        stockMaterielService.save(stockMateriel2);
        //Ajouter des Stocks - fin




        //Ajouter des suivis des PetitMateriel - debut
        suiviePetitMateriel1.setTypeMateriel(TypeMateriel.BALAIS);
        suiviePetitMateriel1.setQuantite(1);
        suiviePetitMateriel1.setDateSortie(LocalDate.parse("2023-01-22"));
        suiviePetitMateriel1.setOuvrierNom(null);
        suiviePetitMateriel1.setVehiculeNumParc(vehicule2.getNumParc());

        suiviePetitMaterielService.save(suiviePetitMateriel1);

        suiviePetitMateriel2.setTypeMateriel(TypeMateriel.PELL);
        suiviePetitMateriel2.setQuantite(1);
        suiviePetitMateriel2.setDateSortie(LocalDate.parse("2023-01-20"));
        suiviePetitMateriel2.setOuvrierNom(null);
        suiviePetitMateriel2.setVehiculeNumParc(vehicule1.getNumParc());

        suiviePetitMaterielService.save(suiviePetitMateriel2);

        //Ajouter des suivis des PetitMateriel - fin

        //Ajouter des carburants- debut
        carburant1.setType("10W40");
        carburant1.setQuantiteConsommee(30d);
        carburant1.setPrixUnit(9.10);
        carburant1.setDateConsomation(LocalDate.parse("2023-02-14"));
        carburant1.setVehicule(vehicule2);

        carburantService.save(carburant1);

        carburant2.setType("e5");
        carburant2.setQuantiteConsommee(10.5);
        carburant2.setPrixUnit(9.10);
        carburant2.setDateConsomation(LocalDate.parse("2023-02-14"));
        carburant2.setVehicule(vehicule1);

        carburantService.save(carburant2);
        //Ajouter des carburants- fin



    }
}
