package com.sf.digitwins.controllers;

import com.sf.digitwins.models.SuiviePetitMateriel;
import com.sf.digitwins.services.SuiviePetitMaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/suiviepetitmateriel",produces = "application/json")
@CrossOrigin("*")
public class SuiviePetitMaterielController {

    @Autowired
    private SuiviePetitMaterielService suiviePetitMaterielService;

    @GetMapping
    public List<SuiviePetitMateriel> getAllSuivies(){
        return suiviePetitMaterielService.findAll();
    }

    @GetMapping("/{matricule}")
    public SuiviePetitMateriel getSuivieByMatricule(@PathVariable Long matricule){
        return suiviePetitMaterielService.findById(matricule);
    }

    @PostMapping
    public SuiviePetitMateriel SuiviePetitMateriel(@RequestBody SuiviePetitMateriel SuiviePetitMateriel){
        return suiviePetitMaterielService.save(SuiviePetitMateriel);
    }

    @PutMapping("/{matricule}")
    public SuiviePetitMateriel updateSuivie(@PathVariable Long matricule,@RequestBody SuiviePetitMateriel SuiviePetitMateriel){
        SuiviePetitMateriel.setPm_matricule(matricule);
        return suiviePetitMaterielService.save(SuiviePetitMateriel);
    }

    @DeleteMapping
    public void deleteAllSSuivies(){
        suiviePetitMaterielService.deleteAll();
    }

    @DeleteMapping("/{matricule}")
    public void deleteSuivieByMatricule(@PathVariable Long matricule){
        suiviePetitMaterielService.deleteById(matricule);
    }

}
