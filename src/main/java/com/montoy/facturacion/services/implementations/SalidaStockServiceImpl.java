package com.montoy.facturacion.services.implementations;

import com.montoy.facturacion.model.ItemSalidaStock;
import com.montoy.facturacion.model.PlanillaStock;
import com.montoy.facturacion.model.Proveedor;
import com.montoy.facturacion.model.SalidaStock;
import com.montoy.facturacion.repositories.PlanillaStockRepository;
import com.montoy.facturacion.repositories.SalidaStockRepository;
import com.montoy.facturacion.services.SalidaStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

@Service
public class SalidaStockServiceImpl implements SalidaStockService {

    @Autowired
    SalidaStockRepository salidaRepo;

    @Autowired
    PlanillaStockRepository planillaRepo;

    @Autowired
    public SalidaStockServiceImpl (SalidaStockRepository salidaStockRepository,
                                   PlanillaStockRepository planillaStockRepository) {
        this.salidaRepo = salidaStockRepository;
        this.planillaRepo = planillaStockRepository;
    }
    @Override
    public List<SalidaStock> retrieveSalidas() {
        return salidaRepo.findAll();
    }

    @Override
    public SalidaStock retrieveByID(Long ID) {
        return salidaRepo.findById(ID).orElse(null);
    }

    @Override
    public List<SalidaStock> retrieveSalidasByProveedor(Proveedor proveedor) {
        return salidaRepo.findByProveedor(proveedor);
    }

    @Override
    public void insertarSalida(SalidaStock salidaStock) {
        LocalDateTime exit = LocalDateTime.now();
        salidaStock.setFecha_salida(exit);
        Iterator<ItemSalidaStock> iiss = salidaStock.getItems().iterator();
        while (iiss.hasNext())
        {
            ItemSalidaStock ISS = iiss.next();
            PlanillaStock planilla = planillaRepo.findByProducto(ISS.getProducto());
            planilla.setFecha_ultima_salida(exit);
            planilla.setCantidad_ultima_salida(ISS.getCantidad());
            planilla.setCantidad_stock(planilla.getCantidad_stock()-ISS.getCantidad());
            planillaRepo.save(planilla);
        }
        salidaRepo.save(salidaStock);
    }
}
