package com.montoy.facturacion.Factories;

import com.montoy.facturacion.exceptions.IncorrectClassCreatorException;
import com.montoy.facturacion.model.Proveedor;
import com.montoy.facturacion.model.ProveedorPersFisica;

public class ProveedorPersFisicaFactory extends AbstractProveedorFactory{
    @Override
    public Proveedor createProveedor() {
        return new ProveedorPersFisica();
    }

    @Override
    public Proveedor createProveedor(Long ID, String email, String telefono, String direccion,
                                     String nombre, String apellido, Integer DNI) {
        ProveedorPersFisica create = new ProveedorPersFisica(nombre,apellido,DNI);
        create.setDeAlta(true);
        create.setEmail(email);
        create.setTelefono(telefono);
        create.setDireccion(direccion);
        create.setIdProveedor(ID);
        return create;
    }

    @Override
    public Proveedor createProveedor(Long ID, String email, String telefono, String direccion,
                                     String razonSocial, String cuit_cuil) throws IncorrectClassCreatorException {
        throw new IncorrectClassCreatorException();
    }

    @Override
    public Proveedor createProveedor(Proveedor copy) {
        ProveedorPersFisica create = new ProveedorPersFisica();
        ProveedorPersFisica copyfisica = (ProveedorPersFisica) copy;
        create.setIdProveedor(copyfisica.getIdProveedor());
        create.setEmail(copyfisica.getEmail());
        create.setDireccion(copyfisica.getDireccion());
        create.setTelefono(copyfisica.getTelefono());
        create.setDeAlta(copyfisica.isDeAlta());
        create.setNombre(copyfisica.getNombre());
        create.setApellido(copyfisica.getApellido());
        create.setDNI(copyfisica.getDNI());
        return create;
    }
}
