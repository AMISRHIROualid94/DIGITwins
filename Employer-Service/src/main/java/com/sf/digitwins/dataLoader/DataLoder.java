package com.sf.digitwins.dataLoader;

import com.sf.digitwins.models.*;
import com.sf.digitwins.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoder implements CommandLineRunner {

    @Autowired
    private EmployerService employerService;

    @Override
    public void run(String... args) throws Exception {


        Employer employer1 = new Employer();
        Employer employer2 = new Employer();
        Employer employer3 = new Employer();

        //Ajouter des Employers - debut

        employer1.setNom("employer1 nom");
        employer1.setPrenom("employer1 prénom");
        employer1.setDateNaissance(LocalDate.parse("1994-02-14"));
        employer1.setSitFamilial(SitFamill.CELIBATAIRE);
        employer1.setNumCnss("123456783");
        employer1.setFonction(Fonction.BALAYEUR);
        employer1.setDateEmbauche(LocalDate.parse("2023-02-14"));
        employer1.setNombreCongePaye(0);
        employer1.setNombreRecuperation(0);
        employer1.setNombreReposTravaille(0);

        employerService.save(employer1);

        employer2.setNom("employer2 nom");
        employer2.setPrenom("employer2 prénom");
        employer2.setDateNaissance(LocalDate.parse("1990-11-10"));
        employer2.setSitFamilial(SitFamill.MARIE);
        employer2.setNombreEnfant(2);
        employer2.setNumCnss("123456783");
        employer2.setFonction(Fonction.CHAUFFEUR);
        employer2.setDateEmbauche(LocalDate.parse("2023-02-12"));
        employer2.setNombreCongePaye(0);
        employer2.setNombreRecuperation(0);
        employer2.setNombreReposTravaille(0);

        employerService.save(employer2);

        employer3.setNom("employer3 nom");
        employer3.setPrenom("employer3 prénom");
        employer3.setDateNaissance(LocalDate.parse("1989-11-10"));
        employer3.setSitFamilial(SitFamill.MARIE);
        employer3.setNombreEnfant(1);
        employer3.setNumCnss("123456083");
        employer3.setFonction(Fonction.GARDIEN);
        employer3.setDateEmbauche(LocalDate.parse("2023-02-12"));
        employer3.setNombreCongePaye(0);
        employer3.setNombreRecuperation(0);
        employer3.setNombreReposTravaille(0);

        employerService.save(employer3);
        //Ajouter des Employers - fin


    }
}
