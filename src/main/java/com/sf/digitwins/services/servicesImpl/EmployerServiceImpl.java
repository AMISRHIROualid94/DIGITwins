package com.sf.digitwins.services.servicesImpl;

import com.sf.digitwins.models.Employer;
import com.sf.digitwins.repositories.EmployerRepository;
import com.sf.digitwins.services.EmployerService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
        Sort sort = Sort.by(Sort.Direction.ASC,"dateEmbauche");
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
