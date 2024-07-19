package com.montoy.facturacion.services;

import com.montoy.facturacion.entitiesLists.RubroLists;
import com.montoy.facturacion.model.Rubro;
import org.springframework.stereotype.Service;
import java.util.List;


public interface RubroService
{
    RubroLists retrieveRubros();

    Rubro retrieveByID(Long ID);

    void addRubro(Rubro rubro);

    void updateRubro(Rubro rubro);
}
