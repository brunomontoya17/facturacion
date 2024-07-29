package com.montoy.facturacion.services.implementations;

import com.montoy.facturacion.model.PlanillaStock;
import com.montoy.facturacion.repositories.PlanillaStockRepository;
import com.montoy.facturacion.services.PlanillaStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanillaStockServiceImpl implements PlanillaStockService {

    @Autowired
    private PlanillaStockRepository planillaRepo;

    @Autowired
    public PlanillaStockServiceImpl (PlanillaStockRepository planillaStockRepository) {
        this.planillaRepo = planillaStockRepository;
    }
    @Override
    public List<PlanillaStock> retrievePlanillas() {
        return planillaRepo.findAll();
    }

    @Override
    public PlanillaStock retrieveByID(Long ID) {
        return planillaRepo.findById(ID).orElse(null);
    }

    @Override
    public void agregarPlanillaStock(PlanillaStock planillaStock) {
        planillaRepo.save(planillaStock);
    }

    @Override
    public void modificarPlanillaStock(PlanillaStock planillaStock) {
        planillaRepo.save(planillaStock);
    }
}
