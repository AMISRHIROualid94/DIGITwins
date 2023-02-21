package com.sf.digitwins.services;

import com.sf.digitwins.models.StockMateriel;
import com.sf.digitwins.models.TypeMateriel;

public interface StockMaterielService extends CrudService<StockMateriel,Long> {

    int findByTypeMateriel(TypeMateriel type);
    StockMateriel findByTypeMaterielObject(TypeMateriel type);
}
