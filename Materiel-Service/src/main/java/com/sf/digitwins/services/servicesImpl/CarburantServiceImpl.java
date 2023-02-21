package com.sf.digitwins.services.servicesImpl;

import com.sf.digitwins.models.Carburant;
import com.sf.digitwins.repositories.CarburantRepository;
import com.sf.digitwins.services.CarburantService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarburantServiceImpl implements CarburantService {

    private final CarburantRepository carburantRepository;

    public CarburantServiceImpl(CarburantRepository carburantRepository) {
        this.carburantRepository = carburantRepository;
    }

    @Override
    public List<Carburant> findAll() {
        List<Carburant> carburants = new ArrayList<>();
        Sort sort = Sort.by(Sort.Direction.ASC,"dateConsomation");
        carburantRepository.findAll(sort).forEach(carburants::add);
        return carburants;
    }

    @Override
    public Carburant findById(Long matricule) {
        Optional<Carburant> carburant = carburantRepository.findById(matricule);
        return carburant.orElse(null);
    }

    @Override
    public Carburant save(Carburant carburant) {
        return carburantRepository.save(carburant);
    }

    @Override
    public void deleteAll() {
        carburantRepository.deleteAll();
    }

    @Override
    public void deleteById(Long matricule) {
        carburantRepository.deleteById(matricule);
    }
}
