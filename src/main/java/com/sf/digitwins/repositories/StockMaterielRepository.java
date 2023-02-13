package com.sf.digitwins.repositories;

import com.sf.digitwins.models.StockMateriel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockMaterielRepository extends JpaRepository<StockMateriel, Long> {

    StockMateriel findByTypeMateriel(String typeMateriel);
}