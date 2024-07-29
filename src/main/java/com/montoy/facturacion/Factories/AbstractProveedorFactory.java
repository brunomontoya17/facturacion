package com.montoy.facturacion.Factories;

import com.montoy.facturacion.exceptions.IncorrectClassCreatorException;
import com.montoy.facturacion.model.Proveedor;

public abstract class AbstractProveedorFactory
{
    public abstract Proveedor createProveedor();

    public abstract Proveedor createProveedor(Long ID,String email,String telefono,String direccion,
                                              String nombre, String apellido, Integer DNI) throws IncorrectClassCreatorException;

    public abstract Proveedor createProveedor(Long ID,String email,String telefono,String direccion,
                                              String razonSocial, String cuit_cuil) throws IncorrectClassCreatorException;

    public abstract Proveedor createProveedor(Proveedor copy);
}
