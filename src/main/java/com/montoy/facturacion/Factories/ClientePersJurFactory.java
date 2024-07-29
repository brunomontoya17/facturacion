package com.montoy.facturacion.Factories;

import com.montoy.facturacion.exceptions.IncorrectClassCreatorException;
import com.montoy.facturacion.model.Cliente;
import com.montoy.facturacion.model.ClientePersFisica;
import com.montoy.facturacion.model.ClientePersJur;

public class ClientePersJurFactory extends AbstractClienteFactory
{
    @Override
    public Cliente createCliente() {
        return new ClientePersJur();
    }

    @Override
    public Cliente createCliente(Long ID, String email, String telefono, String direccion, String nombre, String apellido, Integer DNI) throws IncorrectClassCreatorException {
        throw new IncorrectClassCreatorException();
    }

    @Override
    public Cliente createCliente(Long ID, String email, String telefono, String direccion, String razonSocial, String cuit_cuil) {
        ClientePersJur create = new ClientePersJur(razonSocial,cuit_cuil);
        create.setIdCliente(ID);
        create.setEmail(email);
        create.setTelefono(telefono);
        create.setDireccion(direccion);
        create.setDeAlta(true);
        return create;
    }


    @Override
    public Cliente createCliente(Cliente copy) {
        ClientePersJur create = new ClientePersJur();
        ClientePersJur copyjur = (ClientePersJur) copy;
        create.setIdCliente(copyjur.getIdCliente());
        create.setEmail(copyjur.getEmail());
        create.setDireccion(copyjur.getDireccion());
        create.setTelefono(copyjur.getTelefono());
        create.setDeAlta(copyjur.isDeAlta());
        create.setRazonSocial(copyjur.getRazonSocial());
        create.setCuit_cuil(copyjur.getCuit_cuil());
        return create;
    }
}
