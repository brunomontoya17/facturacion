package com.montoy.facturacion.Factories;

import com.montoy.facturacion.exceptions.IncorrectClassCreatorException;
import com.montoy.facturacion.model.Cliente;

public abstract class AbstractClienteFactory
{
    public abstract Cliente createCliente();

    public abstract Cliente createCliente(Long ID,String email,String telefono,String direccion,
                                          String nombre,String apellido,Integer DNI) throws IncorrectClassCreatorException;

    public abstract Cliente createCliente(Long ID,String email,String telefono,String direccion,
                                          String razonSocial, String cuit_cuil) throws IncorrectClassCreatorException;

    public abstract Cliente createCliente(Cliente copy);
}
