package com.sf.digitwins.services.servicesImpl;

import com.sf.digitwins.models.StockMateriel;
import com.sf.digitwins.models.TypeMateriel;
import com.sf.digitwins.repositories.StockMaterielRepository;
import com.sf.digitwins.services.StockMaterielService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockMaterielServiceImpl implements StockMaterielService {
    private final StockMaterielRepository stockMaterielRepository;

    public StockMaterielServiceImpl(StockMaterielRepository stockMaterielRepository) {
        this.stockMaterielRepository = stockMaterielRepository;
    }


    @Override
    public List<StockMateriel> findAll() {
        List<StockMateriel> stockMateriels = new ArrayList<>();
        Sort sort = Sort.by(Sort.Direction.ASC,"dateEntre");
        stockMaterielRepository.findAll(sort).forEach(stockMateriels::add);
        return stockMateriels;
    }

    @Override
    public StockMateriel findById(Long matricule) {
        Optional<StockMateriel> stockMateriel = stockMaterielRepository.findById(matricule);
        return stockMateriel.orElse(null);
    }

    @Override
    public StockMateriel save(StockMateriel stockMateriel) {
        return stockMaterielRepository.save(stockMateriel);
    }

    @Override
    public void deleteAll() {
        stockMaterielRepository.deleteAll();
    }

    @Override
    public void deleteById(Long matricule) {
        stockMaterielRepository.deleteById(matricule);
    }

    @Override
    public int findByTypeMateriel(TypeMateriel type) {
        int quantite = stockMaterielRepository.findByTypeMateriel(type).getQuantiteInitiale();
        return quantite;
    }

    @Override
    public StockMateriel findByTypeMaterielObject(TypeMateriel type) {
        return stockMaterielRepository.findByTypeMateriel(type);
    }
}
