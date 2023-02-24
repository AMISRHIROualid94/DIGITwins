package com.sf.digitwins.controllers;

import com.sf.digitwins.models.Carburant;
import com.sf.digitwins.services.CarburantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/materiel-service/carburants",produces = "application/json")
@CrossOrigin("*")
public class CarburantController {

    @Autowired
    private CarburantService carburantService;

    @GetMapping
    public List<Carburant> getAllCarburants(){
        return carburantService.findAll();
    }

    @GetMapping("/{matricule}")
    public Carburant getCarburantByMatricule(@PathVariable Long matricule){
        return carburantService.findById(matricule);
    }

    @PostMapping
    public Carburant addCarburant(@RequestBody Carburant carburant){
        return carburantService.save(carburant);
    }

    @PutMapping("/{matricule}")
    public Carburant updateCarburant(@PathVariable Long matricule,@RequestBody Carburant carburant){
        carburant.setCarb_matricule(matricule);
        return carburantService.save(carburant);
    }

    @DeleteMapping
    public void deleteAllCarburant(){
        carburantService.deleteAll();
    }

    @DeleteMapping("/{matricule}")
    public void deleteCarburantByMatricule(@PathVariable Long matricule){
        carburantService.deleteById(matricule);
    }
}
