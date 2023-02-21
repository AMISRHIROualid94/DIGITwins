package com.sf.digitwins.repositories;

import com.sf.digitwins.models.Carburant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarburantRepository extends JpaRepository<Carburant,Long> {
}
