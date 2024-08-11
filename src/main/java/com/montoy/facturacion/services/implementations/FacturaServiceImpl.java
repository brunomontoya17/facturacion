package com.montoy.facturacion.services.implementations;

import com.montoy.facturacion.model.Cliente;
import com.montoy.facturacion.model.Factura;
import com.montoy.facturacion.model.ItemFactura;
import com.montoy.facturacion.model.PlanillaStock;
import com.montoy.facturacion.repositories.ClienteRepository;
import com.montoy.facturacion.repositories.FacturaRepository;
import com.montoy.facturacion.repositories.PlanillaStockRepository;
import com.montoy.facturacion.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService
{
    @Autowired
    private FacturaRepository facturaRepo;

    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private PlanillaStockRepository planillaRepo;

    @Autowired
    public FacturaServiceImpl (FacturaRepository facturaRepository,
                               PlanillaStockRepository planillaStockRepository,
                               ClienteRepository clienteRepository)
    {
        this.facturaRepo = facturaRepository;
        this.planillaRepo = planillaStockRepository;
        this.clienteRepo = clienteRepository;
    }
    @Override
    public List<Factura> retrieveFacturas() {
        return facturaRepo.findAll();
    }

    @Override
    public Factura retrieveByID(Long ID) {
        return facturaRepo.findById(ID).orElse(null);
    }

    @Override
    public List<Factura> retrieveFacturasByCliente(Long ID) {
        Cliente query = clienteRepo.findById(ID).orElse(null);
        return facturaRepo.findByCliente(query);
    }

    @Override
    public Factura insertarFactura(Factura factura) {
        LocalDateTime sale = LocalDateTime.now();
        factura.setFecha(sale);
        Iterator<ItemFactura> iif = factura.getItems().iterator();
        while (iif.hasNext())
        {
            ItemFactura IIFF = iif.next();
            PlanillaStock planilla = planillaRepo.findByProducto(IIFF.getProducto());
            planilla.setFecha_ultima_salida(sale);
            planilla.setCantidad_ultima_salida(IIFF.getCantidad());
            planilla.setCantidad_stock(planilla.getCantidad_stock()-IIFF.getCantidad());
            planillaRepo.save(planilla);
        }
        return facturaRepo.save(factura);
    }
}
