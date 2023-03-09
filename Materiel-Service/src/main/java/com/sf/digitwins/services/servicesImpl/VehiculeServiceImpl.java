package com.sf.digitwins.services.servicesImpl;

import com.sf.digitwins.dto.Employer;
import com.sf.digitwins.models.Vehicule;
import com.sf.digitwins.repositories.VehiculeRepository;
import com.sf.digitwins.services.VehiculeService;
import com.sf.digitwins.services.webClient.WebClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class VehiculeServiceImpl implements VehiculeService {

    private final VehiculeRepository vehiculeRepository;

    private final WebClientService webClientService;

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
        boolean isAffected = webClientService.isChAffected(vehicule.getChauffeurId());
        Employer employer = webClientService.getEmployer(vehicule.getChauffeurId());
        if (isAffected){
            log.info("Already Affected! try again");
        }else {
            log.info("added and Affected successfully!!");
             vehiculeRepository.save(vehicule);
             employer.setAffected(true);
             webClientService.editChauffeurId(vehicule.getChauffeurId(),employer);
        }

        return null;
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
