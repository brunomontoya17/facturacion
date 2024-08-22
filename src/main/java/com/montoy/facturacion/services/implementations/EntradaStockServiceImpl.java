package com.montoy.facturacion.services.implementations;

import com.montoy.facturacion.model.EntradaStock;
import com.montoy.facturacion.model.ItemEntradaStock;
import com.montoy.facturacion.model.PlanillaStock;
import com.montoy.facturacion.model.Proveedor;
import com.montoy.facturacion.repositories.EntradaStockRepository;
import com.montoy.facturacion.repositories.PlanillaStockRepository;
import com.montoy.facturacion.services.EntradaStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

@Service
public class EntradaStockServiceImpl implements EntradaStockService {

    @Autowired
    private EntradaStockRepository entradaRepo;

    @Autowired
    private PlanillaStockRepository planillaRepo;

    @Autowired
    public EntradaStockServiceImpl (EntradaStockRepository entradaStockRepository,
                                    PlanillaStockRepository planillaStockRepository)
    {
        this.entradaRepo = entradaStockRepository;
        this.planillaRepo = planillaStockRepository;
    }

    @Override
    public List<EntradaStock> retrieveEntradas() {
        return entradaRepo.findAll();
    }

    @Override
    public EntradaStock retrieveByID(Long ID) {
        return entradaRepo.findById(ID).orElse(null);
    }

    @Override
    public List<EntradaStock> retrieveEntradasByProveedor(Proveedor proveedor) {
        return entradaRepo.findByProveedor(proveedor);
    }

    @Override
    @Transactional(transactionManager = "transactionManager")
    public void insertarEntradaStock(EntradaStock entrada)
    {
        LocalDateTime buy = LocalDateTime.now();
        entrada.setFecha_entrada(buy);
        Iterator<ItemEntradaStock> iies = entrada.getItems().iterator();
        while (iies.hasNext()){
            ItemEntradaStock IES = iies.next();
            PlanillaStock planilla = planillaRepo.findByProducto(IES.getProducto());
            planilla.setFecha_ultima_entrada(buy);
            planilla.setCantidad_ultima_entrada(IES.getCantidad());
            planilla.setCantidad_stock(planilla.getCantidad_stock()+IES.getCantidad());
            planillaRepo.save(planilla);
        }
        entradaRepo.save(entrada);
    }
}
