package com.sf.digitwins.controllers;

import com.sf.digitwins.models.Vehicule;
import com.sf.digitwins.services.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/vehicules",produces = "application/json")
@CrossOrigin("*")
public class VehiculeController {


    @Autowired
    private VehiculeService vehiculeService;
    
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
