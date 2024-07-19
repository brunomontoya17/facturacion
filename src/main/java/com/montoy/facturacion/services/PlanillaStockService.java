package com.montoy.facturacion.services;

import com.montoy.facturacion.model.PlanillaStock;

import java.util.List;

public interface PlanillaStockService {
    List<PlanillaStock> retrievePlanillas();

    PlanillaStock retrieveByID(Long ID);

    void agregarPlanillaStock(PlanillaStock planillaStock);

    void modificarPlanillaStock(PlanillaStock planillaStock);
}
