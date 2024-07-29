package com.montoy.facturacion.services;

import com.montoy.facturacion.entitiesLists.RubroLists;
import com.montoy.facturacion.model.Rubro;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.List;


public interface RubroService
{
    RubroLists retrieveRubros();

    Rubro retrieveByID(Long ID);

    Page<Rubro> retrieve50perPage (Integer page);

    Page<Rubro> retrieve25perPage (Integer page);

    Page<Rubro> retrieve10perPage (Integer page);

    void addRubro(Rubro rubro);

    void updateRubro(Rubro rubro);
}
