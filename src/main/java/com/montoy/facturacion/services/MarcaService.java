package com.montoy.facturacion.services;

import com.montoy.facturacion.model.Marca;
import com.montoy.facturacion.model.Rubro;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MarcaService
{
    List<Marca> retrieveMarcas();

    Marca retrieveByID(Long ID);

    Page<Marca> retrieve50perPage (Integer page);

    Page<Marca> retrieve25perPage (Integer page);

    Page<Marca> retrieve10perPage (Integer page);

    void addMarca(Marca marca);

    void updateMarca(Marca marca);
}
