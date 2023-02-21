package com.sf.digitwins.repositories;

import com.sf.digitwins.models.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer,Long> {
}
