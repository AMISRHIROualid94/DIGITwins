package com.sf.digitwins.services.servicesImpl;

import com.sf.digitwins.models.StockMateriel;
import com.sf.digitwins.models.SuiviePetitMateriel;
import com.sf.digitwins.models.TypeMateriel;
import com.sf.digitwins.repositories.SuiviePetitMaterielRepository;
import com.sf.digitwins.services.StockMaterielService;
import com.sf.digitwins.services.SuiviePetitMaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SuiviePetitMaterielServiceImpl implements SuiviePetitMaterielService {


    @Autowired
    private StockMaterielService stockMaterielService;
    private final SuiviePetitMaterielRepository suiviePetitMaterielRepository;

    public SuiviePetitMaterielServiceImpl(SuiviePetitMaterielRepository suiviePetitMaterielRepository) {
        this.suiviePetitMaterielRepository = suiviePetitMaterielRepository;
    }


    @Override
    public List<SuiviePetitMateriel> findAll() {
        List<SuiviePetitMateriel> suiviePetitMateriels = new ArrayList<>();
        Sort sort = Sort.by(Sort.Direction.DESC,"typeMateriel");
        suiviePetitMaterielRepository.findAll(sort).forEach(suiviePetitMateriels::add);
        return suiviePetitMateriels;
    }

    @Override
    public SuiviePetitMateriel findById(Long matricule) {
        Optional<SuiviePetitMateriel> petitMateriel = suiviePetitMaterielRepository.findById(matricule);
        return petitMateriel.orElse(null);
    }

    @Override
    public SuiviePetitMateriel save(SuiviePetitMateriel suiviePetitMateriel) {
        int qSortie = suiviePetitMateriel.getQuantite();
        TypeMateriel typeMateriel = suiviePetitMateriel.getTypeMateriel();
        int qStock = stockMaterielService.findByTypeMateriel(typeMateriel);
        StockMateriel stockMateriel = stockMaterielService.findByTypeMaterielObject(typeMateriel);
        int qResante = qStock - qSortie;
        suiviePetitMateriel.setQuantiteResante(qResante);
        stockMateriel.setQuantiteInitiale(qResante);
        stockMateriel.setStock_matricule(stockMateriel.getStock_matricule());
        stockMateriel.setStock_matricule(stockMateriel.getStock_matricule());
        stockMaterielService.save(stockMateriel);
        return suiviePetitMaterielRepository.save(suiviePetitMateriel);
    }

    @Override
    public void deleteAll() {
        suiviePetitMaterielRepository.deleteAll();
    }

    @Override
    public void deleteById(Long matricule) {
            suiviePetitMaterielRepository.deleteById(matricule);
    }
}
