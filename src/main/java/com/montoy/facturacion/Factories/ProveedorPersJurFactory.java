package com.montoy.facturacion.Factories;

import com.montoy.facturacion.exceptions.IncorrectClassCreatorException;
import com.montoy.facturacion.model.Proveedor;
import com.montoy.facturacion.model.ProveedorPersFisica;
import com.montoy.facturacion.model.ProveedorPersJur;

public class ProveedorPersJurFactory extends AbstractProveedorFactory{
    @Override
    public Proveedor createProveedor() {
        return new ProveedorPersJur();
    }

    @Override
    public Proveedor createProveedor(Long ID, String email, String telefono, String direccion, String nombre, String apellido, Integer DNI) throws IncorrectClassCreatorException {
        throw new IncorrectClassCreatorException();
    }

    @Override
    public Proveedor createProveedor(Long ID, String email, String telefono, String direccion, String razonSocial, String cuit_cuil) {
        ProveedorPersJur create = new ProveedorPersJur(razonSocial,cuit_cuil);
        create.setIdProveedor(ID);
        create.setEmail(email);
        create.setTelefono(telefono);
        create.setDireccion(direccion);
        create.setDeAlta(true);
        return create;
    }

    @Override
    public Proveedor createProveedor(Proveedor copy) {
        ProveedorPersJur create = new ProveedorPersJur();
        ProveedorPersJur copyjur = (ProveedorPersJur) copy;
        create.setIdProveedor(copyjur.getIdProveedor());
        create.setEmail(copyjur.getEmail());
        create.setDireccion(copyjur.getDireccion());
        create.setTelefono(copyjur.getTelefono());
        create.setDeAlta(copyjur.isDeAlta());
        create.setRazonSocial(copyjur.getRazonSocial());
        create.setCuit_cuil(copyjur.getCuit_cuil());
        return create;
    }
}
