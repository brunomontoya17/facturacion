package com.montoy.facturacion.services;

import com.montoy.facturacion.model.Marca;

import java.util.List;

public interface MarcaService
{
    List<Marca> retrieveMarcas();

    Marca retrieveByID(Long ID);

    void addMarca(Marca marca);

    void updateMarca(Marca marca);
}
