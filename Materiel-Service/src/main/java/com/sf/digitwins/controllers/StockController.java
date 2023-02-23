package com.sf.digitwins.controllers;

import com.sf.digitwins.models.StockMateriel;
import com.sf.digitwins.services.StockMaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/stocks",produces = "application/json")
@CrossOrigin("*")
public class StockController {

    @Autowired
    private StockMaterielService stockMaterielService;

    @GetMapping
    public List<StockMateriel> getAllStocks(){
        return stockMaterielService.findAll();
    }

    @GetMapping("/{matricule}")
    public StockMateriel getStockByMatricule(@PathVariable Long matricule){
        return stockMaterielService.findById(matricule);
    }

    @PostMapping
    public StockMateriel stockMateriel(@RequestBody StockMateriel stockMateriel){
        return stockMaterielService.save(stockMateriel);
    }

    @PutMapping("/{matricule}")
    public StockMateriel updateStock(@PathVariable Long matricule,@RequestBody StockMateriel stockMateriel){
        stockMateriel.setStock_matricule(matricule);
        return stockMaterielService.save(stockMateriel);
    }

    @DeleteMapping
    public void deleteAllStocks(){
        stockMaterielService.deleteAll();
    }

    @DeleteMapping("/{matricule}")
    public void deleteStockByMatricule(@PathVariable Long matricule){
        stockMaterielService.deleteById(matricule);
    }
}
