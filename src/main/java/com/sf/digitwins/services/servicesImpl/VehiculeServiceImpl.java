package com.sf.digitwins.services.servicesImpl;

import com.sf.digitwins.models.Vehicule;
import com.sf.digitwins.repositories.VehiculeRepository;
import com.sf.digitwins.services.VehiculeService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculeServiceImpl implements VehiculeService {

    private final VehiculeRepository vehiculeRepository;

    public VehiculeServiceImpl(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }


    @Override
    public List<Vehicule> findAll() {
        List<Vehicule> vehicules = new ArrayList<>();
        Sort sort = Sort.by("type");
        vehiculeRepository.findAll(sort).forEach(vehicules::add);
        return vehicules;
    }

    @Override
    public Vehicule findById(Long matricule) {
        Optional<Vehicule> vehicule = vehiculeRepository.findById(matricule);
        return vehicule.orElse(null);
    }

    @Override
    public Vehicule save(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void deleteAll() {
        vehiculeRepository.deleteAll();
    }

    @Override
    public void deleteById(Long matricule) {
        vehiculeRepository.deleteById(matricule);
    }
}
