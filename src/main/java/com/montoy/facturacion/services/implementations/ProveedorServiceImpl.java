package com.montoy.facturacion.services.implementations;

import com.montoy.facturacion.entitiesLists.ProveedorList;
import com.montoy.facturacion.model.Proveedor;
import com.montoy.facturacion.model.ProveedorPersFisica;
import com.montoy.facturacion.model.ProveedorPersJur;
import com.montoy.facturacion.repositories.ProveedorRepository;
import com.montoy.facturacion.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    ProveedorRepository proveedorRepo;
    @Override
    public ProveedorList retrieveProveedores() {
        ProveedorList proveedores = new ProveedorList();
        proveedores.addAll(proveedorRepo.findAll());
        return proveedores;
    }

    @Override
    public Proveedor retrieveByID(Long ID) {
        return proveedorRepo.findById(ID).orElse(null);
    }

    @Override
    public ProveedorPersFisica retrieveByDNI(Integer DNI) {
        return null;
    }

    @Override
    public ProveedorPersJur retrieveByCuil(String Cuil) {
        return null;
    }

    @Override
    public void agregarProveedor(Proveedor proveedor) {
        proveedorRepo.save(proveedor);
    }

    @Override
    public void actualizarProveedor(Proveedor proveedor) {
        proveedorRepo.save(proveedor);
    }
}
