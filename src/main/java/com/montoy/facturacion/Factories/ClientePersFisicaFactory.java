package com.montoy.facturacion.Factories;

import com.montoy.facturacion.exceptions.IncorrectClassCreatorException;
import com.montoy.facturacion.model.Cliente;
import com.montoy.facturacion.model.ClientePersFisica;

public class ClientePersFisicaFactory extends AbstractClienteFactory{
    @Override
    public Cliente createCliente() {
        return new ClientePersFisica();
    }

    @Override
    public Cliente createCliente(Long ID, String email, String telefono, String direccion, String nombre, String apellido, Integer DNI) {
        ClientePersFisica create = new ClientePersFisica(nombre,apellido,DNI);
        create.setIdCliente(ID);
        create.setEmail(email);
        create.setTelefono(telefono);
        create.setDireccion(direccion);
        create.setDeAlta(true);
        return create;
    }

    @Override
    public Cliente createCliente(Long ID, String email, String telefono, String direccion, String razonSocial, String cuit_cuil) throws IncorrectClassCreatorException {
        throw new IncorrectClassCreatorException();
    }


    @Override
    public Cliente createCliente(Cliente copy) {
        ClientePersFisica create = new ClientePersFisica();
        ClientePersFisica copyfisica = (ClientePersFisica) copy;
        create.setIdCliente(copyfisica.getIdCliente());
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
