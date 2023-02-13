package com.sf.digitwins.services;

import com.sf.digitwins.models.StockMateriel;

public interface StockMaterielService extends CrudService<StockMateriel,Long> {

    int findByTypeMateriel(String type);
    StockMateriel findByTypeMaterielObject(String type);
}
