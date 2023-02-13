package com.sf.digitwins.services.servicesImpl;

import com.sf.digitwins.models.PetitMateriel;
import com.sf.digitwins.repositories.PetitMaterielRepository;
import com.sf.digitwins.services.PetitMaterielService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetitMaterielServiceImpl implements PetitMaterielService {


    private final PetitMaterielRepository petitMaterielRepository;

    public PetitMaterielServiceImpl(PetitMaterielRepository petitMaterielRepository) {
        this.petitMaterielRepository = petitMaterielRepository;
    }


    @Override
    public List<PetitMateriel> findAll() {
        List<PetitMateriel> petitMateriels = new ArrayList<>();
        Sort sort = Sort.by(Sort.Direction.DESC,"dateEntre");
        petitMaterielRepository.findAll(sort).forEach(petitMateriels::add);
        return petitMateriels;
    }

    @Override
    public PetitMateriel findById(Long matricule) {
        Optional<PetitMateriel> petitMateriel = petitMaterielRepository.findById(matricule);
        return petitMateriel.orElse(null);
    }

    @Override
    public PetitMateriel save(PetitMateriel petitMateriel) {
        return petitMaterielRepository.save(petitMateriel);
    }

    @Override
    public void deleteAll() {
        petitMaterielRepository.deleteAll();
    }

    @Override
    public void deleteById(Long matricule) {
            petitMaterielRepository.deleteById(matricule);
    }
}
