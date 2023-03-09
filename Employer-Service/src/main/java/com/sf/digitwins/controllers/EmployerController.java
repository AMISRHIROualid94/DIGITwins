package com.sf.digitwins.controllers;

import com.sf.digitwins.models.Employer;
import com.sf.digitwins.services.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/employers",produces = "application/json")
@CrossOrigin(origins = "*")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employer> getAllEmployers(){
        return employerService.findAll();
    }

    @GetMapping("/{matricule}")
    public Employer getEmployerByMatricule(@PathVariable Long matricule){
        return employerService.findById(matricule);
    }

    @PostMapping
    public Employer addNewEmployer(@RequestBody Employer employer){
        return employerService.save(employer);
    }

    @PutMapping("/{matricule}")
    public Employer updateEmployer(@PathVariable Long matricule,@RequestBody Employer employer){
        employer.setMatricule(matricule);
        return employerService.save(employer);
    }

    @PatchMapping("/{matricule}")
    public Employer patchEmployer(@PathVariable Long matricule,@RequestBody Employer employer){
        Employer employer1 = employerService.findById(matricule);
        if(!employer1.isAffected()){
            employer1.setAffected(employer.isAffected());
        }
        if(employer1.isAffected()){
            employer1.setAffected(employer.isAffected());
        }
        return employerService.save(employer1);
    }

    @DeleteMapping
    public void deleteAll(){
        employerService.deleteAll();
    }

    @DeleteMapping("/{matricule}")
    public void deleteByMatricule(@PathVariable Long matricule){
        employerService.deleteById(matricule);
    }
}
