package com.montoy.facturacion.services.implementations;

import com.montoy.facturacion.model.Marca;
import com.montoy.facturacion.repositories.MarcaRepository;
import com.montoy.facturacion.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    MarcaRepository marcaRepo;
    @Override
    public List<Marca> retrieveMarcas() {
        return marcaRepo.findAll();
    }

    @Override
    public Marca retrieveByID(Long ID) {
        return marcaRepo.findById(ID).orElse(null);
    }

    @Override
    public void addMarca(Marca marca) {
        marcaRepo.save(marca);
    }

    @Override
    public void updateMarca(Marca marca) {
        marcaRepo.save(marca);
    }
}
