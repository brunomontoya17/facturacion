package com.montoy.facturacion.services.implementations;

import com.montoy.facturacion.entitiesLists.RubroLists;
import com.montoy.facturacion.model.Rubro;
import com.montoy.facturacion.repositories.RubroRepository;
import com.montoy.facturacion.services.RubroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubroServiceImpl implements RubroService {


    @Autowired
    private final RubroRepository rubroRepo;

    @Autowired
    public RubroServiceImpl (RubroRepository rubroRepository) {
        this.rubroRepo = rubroRepository;
    }
    @Override
    public RubroLists retrieveRubros() {
        RubroLists lists = new RubroLists();
        lists.addAll(rubroRepo.findAll());
        return lists;
    }

    @Override
    public Rubro retrieveByID(Long ID) {
        return rubroRepo.findById(ID).orElse(null);
    }

    @Override
    public Page<Rubro> retrieve50perPage(Integer page) {
        return rubroRepo.findAll(PageRequest.of(page-1,50));
    }

    @Override
    public Page<Rubro> retrieve25perPage(Integer page) {
        return rubroRepo.findAll(PageRequest.of(page-1,25));
    }

    @Override
    public Page<Rubro> retrieve10perPage(Integer page) {
        return rubroRepo.findAll(PageRequest.of(page-1,10));
    }

    @Override
    public void addRubro(Rubro rubro) {
        rubroRepo.save(rubro);
    }

    @Override
    public void updateRubro(Rubro rubro) {
        rubroRepo.save(rubro);
    }
}
