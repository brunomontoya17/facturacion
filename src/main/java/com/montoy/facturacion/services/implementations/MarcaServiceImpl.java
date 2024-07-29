package com.montoy.facturacion.services.implementations;

import com.montoy.facturacion.model.Marca;
import com.montoy.facturacion.repositories.MarcaRepository;
import com.montoy.facturacion.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private MarcaRepository marcaRepo;

    @Autowired
    public MarcaServiceImpl (MarcaRepository marcaRepository) {
        this.marcaRepo = marcaRepository;
    }
    @Override
    public List<Marca> retrieveMarcas() {
        return marcaRepo.findAll();
    }

    @Override
    public Marca retrieveByID(Long ID) {
        return marcaRepo.findById(ID).orElse(null);
    }

    @Override
    public Page<Marca> retrieve50perPage(Integer page) {
        return marcaRepo.findAll(PageRequest.of(page-1,50));
    }

    @Override
    public Page<Marca> retrieve25perPage(Integer page) {
        return marcaRepo.findAll(PageRequest.of(page-1,25));
    }

    @Override
    public Page<Marca> retrieve10perPage(Integer page) {
        return marcaRepo.findAll(PageRequest.of(page-1,10));
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
