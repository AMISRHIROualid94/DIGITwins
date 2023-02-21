package com.sf.digitwins.services.servicesImpl;

import com.sf.digitwins.models.Employer;
import com.sf.digitwins.models.SitFamill;
import com.sf.digitwins.repositories.EmployerRepository;
import com.sf.digitwins.services.EmployerService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployerServiceImpl implements EmployerService {

    private final EmployerRepository employerRepository;

    public EmployerServiceImpl(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public List<Employer> findAll() {
        List<Employer> employers = new ArrayList<>();
        Sort sort = Sort.by(Sort.Direction.DESC,"dateEmbauche");
        employerRepository.findAll(sort).forEach(employers::add);
        return employers;
    }

    @Override
    public Employer findById(Long matricule) {
        Optional<Employer> employer = employerRepository.findById(matricule);
        return employer.orElse(null);
    }

    @Override
    public Employer save(Employer employer) {
        LocalDate localDate = employer.getDateSortie();
        SitFamill sitfamilial = employer.getSitFamilial();
        if (localDate != null){
            employer.setDateSortie(employer.getDateSortie());
        }else {
            employer.setDateSortie(null);
        }
        if (sitfamilial.equals(SitFamill.CELIBATAIRE)){
            employer.setNombreEnfant(0);
        }else{
            employer.setNombreEnfant(employer.getNombreEnfant());
        }
        return employerRepository.save(employer);
    }

    @Override
    public void deleteAll() {
        employerRepository.deleteAll();
    }

    @Override
    public void deleteById(Long matricule) {
        employerRepository.deleteById(matricule);
    }
}
