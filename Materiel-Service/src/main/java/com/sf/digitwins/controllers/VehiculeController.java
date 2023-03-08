package com.sf.digitwins.controllers;

import com.sf.digitwins.dto.Employer;
import com.sf.digitwins.dto.EmployerResponse;
import com.sf.digitwins.models.Vehicule;
import com.sf.digitwins.services.VehiculeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/materiel-service/vehicules",produces = "application/json")
@CrossOrigin("*")
@RequiredArgsConstructor
public class VehiculeController {


    private final WebClient.Builder builder;
    @Autowired
    private VehiculeService vehiculeService;


    @GetMapping("/employers")
    public List<EmployerResponse> getAllEmployers(){
        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Employer[] employers = builder.build().get()
                .uri("http://localhost:8080/api/employers")
                .headers(header -> header.setBearerAuth(jwt.getTokenValue()))
                .retrieve()
                .bodyToMono(Employer[].class)
                .block();
        List<EmployerResponse> employerResponses = new ArrayList<>();

        Arrays.stream(employers).forEach(employer -> {
            EmployerResponse employerResponse = new EmployerResponse();
            employerResponse.setNom(employer.getNom());
            employerResponse.setPrenom(employer.getPrenom());
            employerResponse.setFonction(employer.getFonction().toString());
            employerResponses.add(employerResponse);
        });

        return employerResponses;
    }

    @GetMapping
    public List<Vehicule> getAllVehicules(){
        return vehiculeService.findAll();
    }

    @GetMapping("/{matricule}")
    public Vehicule getVehiculeByMatricule(@PathVariable Long matricule){
        return vehiculeService.findById(matricule);
    }

    @PostMapping
    public Vehicule addVehicule(@RequestBody Vehicule Vehicule){
        return vehiculeService.save(Vehicule);
    }

    @PutMapping("/{matricule}")
    public Vehicule updateVehicule(@PathVariable Long matricule,@RequestBody Vehicule Vehicule){
        Vehicule.setVeh_matricule(matricule);
        return vehiculeService.save(Vehicule);
    }

    @DeleteMapping
    public void deleteAllVehicules(){
        vehiculeService.deleteAll();
    }

    @DeleteMapping("/{matricule}")
    public void deleteVehiculeByMatricule(@PathVariable Long matricule){
        vehiculeService.deleteById(matricule);
    }

}
